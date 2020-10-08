package com.example.demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.entity.Response;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.CommonErrorException;
import io.jsonwebtoken.JwtException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.demo.entity.Response;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.logging.Logger;
@Component
public class LoginHandleInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    //Logger log= (Logger) LoggerFactory.getLogger(LoginHandleInterceptor.class);
    //调用目标方法之前被拦截,一个拦截器，只有preHandle方法返回true，postHandle、afterCompletion才有可能被执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI().toString();
        //log.info("request.getRequestURI():"+url);
       User loginUser= (User) request.getSession().getAttribute("loginUser");
       String token=request.getHeader("token");

       if(loginUser!=null)
       {
           if(token==null){
              // return new Response("无token，请重新登录",-1,false);
               //throw new RuntimeException("无token，请重新登录");
               throw new CommonErrorException("-1","无token，请重新登录");

           }
           //获取token中的user_id
           String user_id;
           try{
               user_id= JWT.decode(token).getAudience().get(0);
           }catch (JwtException j){
               throw new RuntimeException("401");
           }
           int user_id01;
           user_id01=Integer.parseInt(user_id);
           User user=userService.queryByUserId(user_id01);
           if(user==null){
               throw  new RuntimeException("用户不存在，请重新登录");
           }
           //验证token
           JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(user.getPassword())).build();
           try {
               jwtVerifier.verify(token);
           }catch (JWTVerificationException e){
               throw new RuntimeException("401");
           }
           //已经登录过，放行
           return true;
       }
       //没有登录过
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=null;
        try {
            JSONObject res=new JSONObject();
            res.put("success",false);
            res.put("msg","用户未登录！");
            out=response.getWriter();
            out.append(res.toString());
            //request.setAttribute("msg","没有权限，请先登录！");
            //转发到登录页面，不能使用重定向，如果使用重定向，则无法把现在的msg信息转发出去
            //request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }

    }
}
