package com.xiong.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xiong.demo.constants.RedisConstants;
import com.xiong.demo.entity.User;
import com.xiong.demo.mapper.UserMapper;
import com.xiong.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private JedisCluster redis;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> userList = null;
        try {
            String users = redis.get(RedisConstants.getUsersKey());
            if ("-1".equals(users)){
                return null;
            }

            if (!StringUtils.isEmpty(users)){
                log.info("UserServiceImpl getUsers from redis");
                userList = JSONArray.parseArray(users, User.class);
            } else {
                log.info("UserServiceImpl getUsers from DB");
                userList = userMapper.getUsers();
                String cache = "-1";
                // 防止缓存击穿，若数据库中也没数据，则存入一个flag
                if (CollectionUtils.isEmpty(userList)){
                    log.info("UserServiceImpl getUsers from DB is null");
                    redis.set(RedisConstants.getUsersKey(), cache);
                    return null;
                }
                redis.set(RedisConstants.getUsersKey(), JSON.toJSONString(userList));
            }
        } catch(Exception e) {
            log.error("UserServiceImpl getUsers have an exception:{}", e);
        }
        log.info("UserServiceImpl getUsers userList:{}", userList);
        return userList;
    }
}
