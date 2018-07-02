package com.jskj.micro.model.jpacreate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpaCerateModel
 * @description
 * @date 2018-05-10 13:43 星期四
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20) COMMENT '主键id'")
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    protected Date createTime = new Date();

    @Column(columnDefinition = "bigint(20) COMMENT '创建者'")
    @JsonIgnore
    protected Long createId;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    @Column(columnDefinition = "datetime COMMENT '更新时间'")
    protected Date updateTime = new Date();

    @Column(columnDefinition = "bigint(20) COMMENT '更新者'")
    @JsonIgnore
    protected Long updateId;

    @Column(columnDefinition = "varchar(255) COMMENT '备注'")
    @JsonIgnore
    protected String remark;

    @Column(columnDefinition = "varchar(32) default 0 COMMENT '是否删除：0否 1是  默认：0'")
    @JsonIgnore
    protected String isDelete;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createTime", createTime)
                .append("createId", createId)
                .append("updateTime", updateTime)
                .append("updateId", updateId)
                .append("remark", remark)
                .append("isDelete", isDelete)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BaseModel)) {
            return false;
        }

        BaseModel that = (BaseModel) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(createTime, that.createTime)
                .append(createId, that.createId)
                .append(updateTime, that.updateTime)
                .append(updateId, that.updateId)
                .append(remark, that.remark)
                .append(isDelete, that.isDelete)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(createTime)
                .append(createId)
                .append(updateTime)
                .append(updateId)
                .append(remark)
                .append(isDelete)
                .toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }


    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
