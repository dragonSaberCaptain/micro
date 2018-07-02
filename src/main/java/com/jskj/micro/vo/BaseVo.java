package com.jskj.micro.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo
 * //基类VO
 * @date 2018-06-06 11:57 星期三
 */
public class BaseVo implements Serializable {
    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    @ApiModelProperty(value = "创建者", name = "createId", hidden = true)
    @JsonIgnore
    private Long createId;

    @ApiModelProperty(value = "创建时间", name = "createTime", hidden = true)
    private String createTime;

    @ApiModelProperty(value = "是否删除：0否 1是 默认：0", name = "isDelete", hidden = true)
    @JsonIgnore
    private String isDelete;

    @ApiModelProperty(value = "备注", name = "remark", hidden = true)
    @JsonIgnore
    private String remark;

    @ApiModelProperty(value = "更新者", name = "updateId", hidden = true)
    @JsonIgnore
    private Long updateId;

    @ApiModelProperty(value = "更新时间", name = "updateTime", hidden = true)
    private String updateTime;

    @ApiModelProperty(value = "图片数组", name = "picPaths", hidden = true)
    private List<String> picPaths;

    public List<String> getPicPaths() {
        return picPaths;
    }

    public void setPicPaths(List<String> picPaths) {
        this.picPaths = picPaths;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createId", createId)
                .append("createTime", createTime)
                .append("isDelete", isDelete)
                .append("remark", remark)
                .append("updateId", updateId)
                .append("updateTime", updateTime)
                .append("picPaths", picPaths)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BaseVo)) {
            return false;
        }

        BaseVo baseVo = (BaseVo) o;

        return new EqualsBuilder()
                .append(getId(), baseVo.getId())
                .append(getCreateId(), baseVo.getCreateId())
                .append(getCreateTime(), baseVo.getCreateTime())
                .append(getIsDelete(), baseVo.getIsDelete())
                .append(getRemark(), baseVo.getRemark())
                .append(getUpdateId(), baseVo.getUpdateId())
                .append(getUpdateTime(), baseVo.getUpdateTime())
                .append(getPicPaths(), baseVo.getPicPaths())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getCreateId())
                .append(getCreateTime())
                .append(getIsDelete())
                .append(getRemark())
                .append(getUpdateId())
                .append(getUpdateTime())
                .append(getPicPaths())
                .toHashCode();
    }
}
