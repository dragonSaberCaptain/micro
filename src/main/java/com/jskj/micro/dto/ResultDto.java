package com.jskj.micro.dto;

import com.jskj.micro.enums.ResultEnum;

import java.io.Serializable;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.dto
 * @description
 * @date 2018-05-04 13:34 星期五
 */

public class ResultDto<T> implements Serializable {
    protected String code;
    protected String msg;

    protected T data;

    public ResultDto(ResultEnum resultEnum) {
        super();
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ResultDto(ResultEnum resultEnum, T data) {
        super();
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public ResultDto(String code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDto(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultDto(int code, String msg) {
        super();
        this.code = String.valueOf(code);
        this.msg = msg;
    }


    public ResultDto() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}