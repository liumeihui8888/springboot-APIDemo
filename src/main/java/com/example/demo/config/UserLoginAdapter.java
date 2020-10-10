package com.example.demo.config;

import com.example.demo.interceptor.LoginHandleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserLoginAdapter implements WebMvcConfigurer {

    @Autowired
    LoginHandleInterceptor loginHandleInterceptor=new LoginHandleInterceptor();
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandleInterceptor)
                //指定要拦截的请求/**表示拦截所有的请求
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/logout","/register"); //要排除的，不需要拦截的请求接口，包括登录与退出

    }
}
