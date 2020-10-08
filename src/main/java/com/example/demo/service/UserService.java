package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    void addUserInfo();
    int addUser(String username,String password); //用户注册时，添加用户
    List<User> queryByUsername(String username); //用户登录时，验证用户
    User queryByUserId(int id);
}
