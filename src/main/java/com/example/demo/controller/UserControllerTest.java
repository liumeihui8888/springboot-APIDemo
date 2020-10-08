package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserTest;
import com.example.demo.service.UserServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerTest {

    @Autowired
    UserServiceTest service;
    @RequestMapping(value = "/getUserItem",method = RequestMethod.GET)
    public String getUserItem() {
        UserTest user = service.getUserInfo();
        return user.toString();
    }
}
