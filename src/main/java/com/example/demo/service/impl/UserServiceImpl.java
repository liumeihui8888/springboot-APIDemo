package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    public void addUserInfo() {
        String username="jack";
        String password="123";
        String icon="jpg";
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setIcon(icon);
        userMapper.addUserInfo(user);
    }

    @Override
    public int addUser(String username, String password) {
        User user1=new User(username,password);
        int count= userMapper.addUser(user1);
        return count;
    }

    @Override
    public List<User> queryByUsername(String username) {
        List<User> userList=userMapper.queryByUsername(username);
        return userList;
    }

    @Override
    public User queryByUserId(int id) {
        User user=userMapper.queryByUserId(id);
        return user;
    }
}
