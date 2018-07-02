package com.jskj.micro.model.fluorit;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model
 * @description
 * @date 2018-05-07 18:02 星期一
 */
public class AccessTokenModel {
    /**
     * data : {"accessToken":"at.7jrcjmna8qnqg8d3dgnzs87m4v2dme3l-32enpqgusd-1jvdfe4-uxo15ik0s","expireTime":1470810222045}
     * code : 200
     * msg : 操作成功!
     */

    private DataBean data;
    private String   code;
    private String   msg;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("data", data)
                .append("code", code)
                .append("msg", msg)
                .toString();
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * accessToken : at.7jrcjmna8qnqg8d3dgnzs87m4v2dme3l-32enpqgusd-1jvdfe4-uxo15ik0s
         * expireTime : 1470810222045
         */

        private String accessToken;
        private long   expireTime;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(long expireTime) {
            this.expireTime = expireTime;
        }
    }
}
