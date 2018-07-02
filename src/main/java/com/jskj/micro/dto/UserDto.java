package com.jskj.micro.dto;


import com.jskj.micro.enums.UserEnum;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo
 * @description
 * @date 2018-05-14 15:38 星期一
 */
public class UserDto<T> extends ResultDto<T> {
    public UserDto(UserEnum userEnum) {
        this.code = userEnum.getCode();
        this.msg = userEnum.getMsg();
    }

    public UserDto(UserEnum userEnum, T data) {
        this.code = userEnum.getCode();
        this.msg = userEnum.getMsg();
        this.data = data;
    }
}
