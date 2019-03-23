package com.xiong.demo.web.controller;

import com.xiong.demo.entity.User;
import com.xiong.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        log.info("UserController getUsers begin...");
        List<User> list = userService.getUsers();
        log.info("UserController getUsers end...list:{}", list);
        return list;
    }
}
