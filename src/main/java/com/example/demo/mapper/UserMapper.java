package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    void addUserInfo(User user);

    int addUser(User user);
    List<User> queryByUsername( String username);
    User queryByUserId(int id);
}
