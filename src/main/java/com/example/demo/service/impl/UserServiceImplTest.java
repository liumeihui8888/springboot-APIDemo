package com.example.demo.service.impl;

import com.example.demo.entity.UserTest;
import com.example.demo.service.UserServiceTest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplTest implements UserServiceTest {
    @Override
    public UserTest getUserInfo() {
        UserTest user = new UserTest();
        user.setName("jack");
        user.setPassword("12341234");
        return user;
    }
}
