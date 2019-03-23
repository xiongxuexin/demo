package com.xiong.demo.enums;

public enum ResponseEnum {
    USER_NOT_EXIST("1000", "用户不存在");
    private String code;
    private String msg;

    ResponseEnum(String code, String msg){
        this.code = code;
        this.msg = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
