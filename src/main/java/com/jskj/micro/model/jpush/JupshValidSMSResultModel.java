package com.jskj.micro.model.jpush;

import cn.jsms.api.ValidSMSResult;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpush
 * @description
 * @date 2018-05-14 9:52 星期一
 */
public class JupshValidSMSResultModel extends ValidSMSResult {
    /**
     * is_valid : false
     * error : {"code":50011,"message":"expired code"}
     */

    private boolean   is_valid;
    private ErrorBean error;

    public boolean isIs_valid() {
        return is_valid;
    }

    public void setIs_valid(boolean is_valid) {
        this.is_valid = is_valid;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class ErrorBean {
        /**
         * code : 50011
         * message : expired code
         */

        private int    code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
