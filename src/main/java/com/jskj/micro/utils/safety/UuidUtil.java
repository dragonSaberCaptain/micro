package com.jskj.micro.utils.safety;

import java.util.UUID;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils
 * @description
 * @date 2018-05-06 13:57 星期日
 */
public class UuidUtil {
    /**
     * 随机生成UUID的字符串
     *
     * @param
     * @return 返回String类型的randomUUID
     * @see
     */
    public static String creatUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
