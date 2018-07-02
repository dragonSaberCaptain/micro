package com.jskj.micro.vo.user;

import com.alibaba.fastjson.JSON;
import com.jskj.micro.model.micro.MUser;
import com.jskj.micro.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.micro.vo.user
 * //TODO
 * @date 2018-06-27 16:28 星期三
 */
@ApiModel(value = "用户查询对象", description = "用于用户查询接口")
public class UserFindVo extends BaseVo {
    @ApiModelProperty(value = "是否是呼叫方", name = "isCaller")
    private String isCaller;
    @ApiModelProperty(value = "手机号", name = "mobile")
    private String mobile;
    @ApiModelProperty(value = "房间号", name = "roomNumber")
    private String roomNumber;
    @ApiModelProperty(value = "摄像机位置", name = "cameraPosition")
    private String cameraPosition;
    @ApiModelProperty(value = "摄像机位置", name = "cameraPosition")
    private String cameraDirection;
    @ApiModelProperty(value = "手机设备号", name = "cameraPosition")
    private String equipmentNumber;

    public static MUser voToDao(final UserFindVo recordVo) {
        return JSON.parseObject(JSON.toJSONString(recordVo), MUser.class);
    }

    public static List<MUser> voToDao(final List<UserFindVo> recordVos) {
        List<MUser> records = new LinkedList<>();
        for (UserFindVo recordVo : recordVos) {
            records.add(JSON.parseObject(JSON.toJSONString(recordVo), MUser.class));
        }
        return records;
    }

    public static UserFindVo daoToVo(final MUser record) {
        return JSON.parseObject(JSON.toJSONString(record), UserFindVo.class);
    }

    public static List<UserFindVo> daoToVo(final List<MUser> records) {
        List<UserFindVo> recordVos = new LinkedList<>();
        for (MUser record : records) {
            recordVos.add(JSON.parseObject(JSON.toJSONString(record), UserFindVo.class));
        }
        return recordVos;
    }

    public String getIsCaller() {
        return isCaller;
    }

    public UserFindVo setIsCaller(String isCaller) {
        this.isCaller = isCaller;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserFindVo setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public UserFindVo setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public String getCameraPosition() {
        return cameraPosition;
    }

    public UserFindVo setCameraPosition(String cameraPosition) {
        this.cameraPosition = cameraPosition;
        return this;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public UserFindVo setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
        return this;
    }

    public String getCameraDirection() {
        return cameraDirection;
    }

    public UserFindVo setCameraDirection(String cameraDirection) {
        this.cameraDirection = cameraDirection;
        return this;
    }
}

