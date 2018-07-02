package com.jskj.micro.model.jpacreate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.micro.model.jpacreate
 * //TODO
 * @date 2018-06-27 09:53 星期三
 */
@Entity
@Table(name = "m_user")
public class UserJpa extends BaseModel {
    @Column(columnDefinition = "varchar(32) COMMENT '手机号'")
    private String mobile;

    @Column(columnDefinition = "varchar(32) COMMENT '房间号'")
    private String roomNumber;

    @Column(columnDefinition = "varchar(32) COMMENT '是否是呼叫方'")
    private String isCaller;

    @Column(columnDefinition = "varchar(32) COMMENT '摄像头位置'")
    private String cameraPosition;

    @Column(columnDefinition = "varchar(32) COMMENT '摄像头方向'")
    private String cameraDirection;

    @Column(columnDefinition = "varchar(32) COMMENT '手机设备号'")
    private String equipmentNumber;
}
