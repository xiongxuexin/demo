package com.xiong.demo.service.impl;

import com.xiong.demo.entity.User;
import com.xiong.demo.mapper.UserMapper;
import com.xiong.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
