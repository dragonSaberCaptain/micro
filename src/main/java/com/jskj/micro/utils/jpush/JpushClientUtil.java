package com.jskj.micro.utils.jpush;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import com.jskj.micro.config.jpush.JpushConfig;

import java.util.Map;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils.jpush
 * @description
 * @date 2018-05-09 9:11 星期三
 */
public class JpushClientUtil {
    private static JPushClient jPushClient = null;

    private static PushPayload pushPayload = null;

    static {
        jPushClient = new JPushClient(JpushConfig.MASTERSECRET, JpushConfig.APPKEY);
    }

    public static PushResult sendAndroidMessageWithAlias(String title, String msgContent, Map<String, String> extras, String alias) throws APIConnectionException, APIRequestException {
        pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder().setTitle(title).setMsgContent(msgContent).addExtras(extras).build())
                .build();
        return jPushClient.sendPush(pushPayload);
    }

    public static PushResult sendAndroidMessageWithAlias(String title, String msgContent, String alias) throws APIConnectionException, APIRequestException {
        pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder().setTitle(title).setMsgContent(msgContent).build())
                .build();
        return jPushClient.sendPush(pushPayload);
    }
}
