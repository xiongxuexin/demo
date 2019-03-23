package com.xiong.demo.exception;

import com.xiong.demo.enums.ResponseEnum;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1960641320073662667L;

    private ResponseEnum responseEnum;

    /**
     * 错误代码
     */
    private String code;

    /**
     * 错误消息
     */
    private String msg;

    public BusinessException(ResponseEnum responseEnum){
        this.responseEnum = responseEnum;
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    public BusinessException(ResponseEnum responseEnum, Throwable t){
        super(t);
        this.responseEnum = responseEnum;
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    public BusinessException(Throwable t){
        super(t);
    }

    public BusinessException(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String code, String msg, Throwable t){
        super(t);
        this.code = code;
        this.msg = msg;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
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
