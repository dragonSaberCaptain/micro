package com.jskj.micro.utils.jpush;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jsms.api.JSMSClient;
import cn.jsms.api.SendSMSResult;
import cn.jsms.api.ValidSMSResult;
import cn.jsms.api.common.model.SMSPayload;
import com.jskj.micro.config.jpush.JpushConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils
 * @description
 * @date 2018-05-04 16:05 星期五
 */
public class JpushSMSUtil {
    private static JSMSClient jsmsClient = null;
    private static SMSPayload smsPayload = null;

    static {
        jsmsClient = new JSMSClient(JpushConfig.MASTERSECRET, JpushConfig.APPKEY);
    }

    /**
     * @param mobile 手机号
     * @param tempId 短信模板
     * @return 成功返回msgId用于sendValidSMSCode方法验证使用
     * @description 通过手机号发送短信验证码
     * @author dragonSaberCaptain
     * @date 2018-05-04 17:41:02
     */
    public static SendSMSResult sendSMSCode(String mobile, int tempId) throws APIConnectionException, APIRequestException {
        if (StringUtils.isBlank(mobile)) {
            return null;
        }
        smsPayload = SMSPayload.newBuilder().setMobileNumber(mobile).setTempId(tempId).build();
        return jsmsClient.sendSMSCode(smsPayload);
    }

    /**
     * @param msgId
     * @param code  验证码
     * @return 是否成功
     * @description
     * @author dragonSaberCaptain
     * @date 2018-05-04 17:44:00
     */
    public static ValidSMSResult sendValidSMSCode(String msgId, String code) throws APIConnectionException, APIRequestException {
        return jsmsClient.sendValidSMSCode(msgId, code);
    }
}
