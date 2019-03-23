package com.xiong.demo.mapper;

import com.xiong.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUsers();
}
