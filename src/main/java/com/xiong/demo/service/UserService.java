package com.xiong.demo.service;

import com.xiong.demo.entity.User;
import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> getUsers();

}
