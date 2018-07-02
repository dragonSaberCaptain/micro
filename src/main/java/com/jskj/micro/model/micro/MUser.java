/* https://github.com/orange1438 */
package com.jskj.micro.model.micro;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LastChaosCaptain
 */
public class MUser implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -1647486578501291201L;

    // 主键id
    private Long id;

    // 创建者
    private Long createId;

    // 创建时间
    private Date createTime;

    // 是否删除：0否 1是  默认：0  默认：0
    private String isDelete;

    // 备注
    private String remark;

    // 更新者
    private Long updateId;

    // 更新时间
    private Date updateTime;

    // 是否是呼叫方
    private String isCaller;

    // 手机号
    private String mobile;

    // 房间号
    private String roomNumber;

    // 摄像头位置
    private String cameraPosition;

    // 手机设备号
    private String equipmentNumber;

    // 摄像头方向
    private String cameraDirection;

    /**
     * 获取 主键id m_user.id
     *
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id m_user.id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建者 m_user.create_id
     *
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 m_user.create_id
     *
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 创建时间 m_user.create_time
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 m_user.create_time
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 是否删除：0否 1是  默认：0 m_user.is_delete
     *
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除：0否 1是  默认：0 m_user.is_delete
     *
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取 备注 m_user.remark
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 m_user.remark
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 更新者 m_user.update_id
     *
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 m_user.update_id
     *
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 更新时间 m_user.update_time
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 m_user.update_time
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 是否是呼叫方 m_user.is_caller
     *
     * @return 是否是呼叫方
     */
    public String getIsCaller() {
        return isCaller;
    }

    /**
     * 设置 是否是呼叫方 m_user.is_caller
     *
     * @param isCaller 是否是呼叫方
     */
    public void setIsCaller(String isCaller) {
        this.isCaller = isCaller == null ? null : isCaller.trim();
    }

    /**
     * 获取 手机号 m_user.mobile
     *
     * @return 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 手机号 m_user.mobile
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 房间号 m_user.room_number
     *
     * @return 房间号
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * 设置 房间号 m_user.room_number
     *
     * @param roomNumber 房间号
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    /**
     * 获取 摄像头位置 m_user.camera_position
     *
     * @return 摄像头位置
     */
    public String getCameraPosition() {
        return cameraPosition;
    }

    /**
     * 设置 摄像头位置 m_user.camera_position
     *
     * @param cameraPosition 摄像头位置
     */
    public void setCameraPosition(String cameraPosition) {
        this.cameraPosition = cameraPosition == null ? null : cameraPosition.trim();
    }

    /**
     * 获取 手机设备号 m_user.equipment_number
     *
     * @return 手机设备号
     */
    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    /**
     * 设置 手机设备号 m_user.equipment_number
     *
     * @param equipmentNumber 手机设备号
     */
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber == null ? null : equipmentNumber.trim();
    }

    /**
     * 获取 摄像头方向 m_user.camera_direction
     *
     * @return 摄像头方向
     */
    public String getCameraDirection() {
        return cameraDirection;
    }

    /**
     * 设置 摄像头方向 m_user.camera_direction
     *
     * @param cameraDirection 摄像头方向
     */
    public void setCameraDirection(String cameraDirection) {
        this.cameraDirection = cameraDirection == null ? null : cameraDirection.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", remark=").append(remark);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isCaller=").append(isCaller);
        sb.append(", mobile=").append(mobile);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", cameraPosition=").append(cameraPosition);
        sb.append(", equipmentNumber=").append(equipmentNumber);
        sb.append(", cameraDirection=").append(cameraDirection);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MUser other = (MUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getIsCaller() == null ? other.getIsCaller() == null : this.getIsCaller().equals(other.getIsCaller()))
                && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
                && (this.getRoomNumber() == null ? other.getRoomNumber() == null : this.getRoomNumber().equals(other.getRoomNumber()))
                && (this.getCameraPosition() == null ? other.getCameraPosition() == null : this.getCameraPosition().equals(other.getCameraPosition()))
                && (this.getEquipmentNumber() == null ? other.getEquipmentNumber() == null : this.getEquipmentNumber().equals(other.getEquipmentNumber()))
                && (this.getCameraDirection() == null ? other.getCameraDirection() == null : this.getCameraDirection().equals(other.getCameraDirection()));
    }

    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsCaller() == null) ? 0 : getIsCaller().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getRoomNumber() == null) ? 0 : getRoomNumber().hashCode());
        result = prime * result + ((getCameraPosition() == null) ? 0 : getCameraPosition().hashCode());
        result = prime * result + ((getEquipmentNumber() == null) ? 0 : getEquipmentNumber().hashCode());
        result = prime * result + ((getCameraDirection() == null) ? 0 : getCameraDirection().hashCode());
        return result;
    }
}