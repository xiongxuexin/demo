package com.xiong.demo.constants;

public class RedisConstants {

    /**
     * 获取所有用户列表的key
     * @return
     */
    public static String getUsersKey(){
        return "demo:user:list";
    }
}
