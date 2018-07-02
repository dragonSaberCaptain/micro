package com.jskj.micro.model.fluorit;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.fluorit
 * @description
 * @date 2018-05-08 17:52 星期二
 */
public class AccountIdModel {

    /**
     * data : {"accountId":"b3ad7ba927524b748e557572024d4ac2"}
     * code : 200
     * msg : 操作成功!
     */

    private DataBean data;
    private String   code;
    private String   msg;

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
         * accountId : b3ad7ba927524b748e557572024d4ac2
         */

        private String accountId;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }
    }
}
