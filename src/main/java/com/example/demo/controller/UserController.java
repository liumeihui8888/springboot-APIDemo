package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.PassToken;
import com.example.demo.annotation.UserLoginToken;
import com.example.demo.entity.Response;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/addUserInfo",method = RequestMethod.GET)
    public Response addUserInfo(){
        userService.addUserInfo();
        Response res = new Response();
        res.setMsg("添加成功");
        res.setCode(1);
        return res;
    }
    @UserLoginToken
    @RequestMapping(value = "/findbyUserId",method = RequestMethod.POST)
    public Response findByUserId(@RequestBody Map<String,String> person ){
        int id= Integer.parseInt(person.get("id"));
        User user=userService.queryByUserId(id);
        if(user!=null) {
            return new Response("查询成功", 1, true, user);
        }else {
            return new Response("用户不存在",-1,false);
        }

    }
    @PassToken
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Response register(@RequestParam Map<String,String> person){
        System.out.println("开始注册了88888888888");
      String username=person.get("username");
      String password=person.get("password");
       // System.out.println("传入的username是："+username);
        //System.out.println("传入的password是："+password);
      if(username!=null &&password!=null){
          JSONObject jsonObject=new JSONObject();
          jsonObject.put("username",username);
          jsonObject.put("password",password);
          List<User> users=userService.queryByUsername(username);
          if(users.size()>0 && users!=null){
              System.out.println("注册失败，用户名重复，请更换");
              return new Response("注册失败，用户名重复，请更换",-1,true);
          }else {
              int count=userService.addUser(username,password);
              if(count>0){
                  System.out.println("注册成功");
                  return new Response("注册成功",1,true,jsonObject);
              }else{
                  System.out.println("注册失败");
                  return new Response("注册失败",-1,false);
              }
          }
      }else {
          return new Response("注册失败，请检查用户名，密码是否为空",-1,false);
      }
    }
    @PassToken
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Response logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return new Response("您已经退出",1,true);
    }
    @PassToken
    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public Response login(@RequestParam Map<String, String> person,HttpSession session){
        JSONObject jsonObject=new JSONObject();
        //session.removeAttribute("loginUser");
        //System.out.println("66666666666666666666"+session);
        String username=person.get("username");
        String password=person.get("password");
        System.out.println("password="+password+"user.getPassword()="+username);
        if(username!=null && password!=null){
            List<User> users=userService.queryByUsername(username);
            if(users.size()>0&& users!=null){
                User user=users.get(0);
                System.out.println("接收的用户是："+user);
                //equals()是判断字符串是否相等的。“==”是判断int整数是否相等的
                if(password.equals(user.getPassword())){
                    System.out.println("password.equals(user.getPassword())是："+password.equals(user.getPassword()));
                    //将用户名放到session中
                    session.setAttribute("loginUser",user);
                    //String token= MD5Util.getToken(user);
                    //String token=MD5Util.createToken(user);
                    String token=MD5Util.generateToken(user);
                    jsonObject.put("token",token);
                    jsonObject.put("user",user);
                    System.out.println("登录成功，token是："+token);
                    return new Response("登录成功",1,true,jsonObject);
                }else {
                    System.out.println("password="+password+"user.getPassword()="+user.getPassword());
                    System.out.println("登录失败");
                    return new Response("登录失败",-1,false);
                }

            }else {
                System.out.println("登录失败，用户名不存在");
                return new Response("登录失败，用户名不存在",-1,false);
            }
        }else {
            return new Response("登录失败，请检查用户名或密码是否为空",-1,false);
        }

    }

}
