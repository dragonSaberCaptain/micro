package com.jskj.micro.exception;


import com.jskj.micro.enums.UserEnum;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.exception
 * @description
 * @date 2018-05-14 15:16 星期一
 */
public class UserException extends RuntimeException {
    private String code;
    private String msg;

    public UserException(UserEnum userEnum) {
        this.code = userEnum.getCode();
        this.msg = userEnum.getMsg();
    }

    public UserException(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
