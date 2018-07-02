package com.jskj.micro.utils.string;

import org.apache.commons.lang3.StringUtils;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils
 * @description
 * @date 2018-05-07 11:57 星期一
 */
public class StringUtil extends StringUtils {
    public static String toUpperFristChar(String string) {
        char[] charArray = string.toCharArray();
        charArray[0] -= 32;
        return String.valueOf(charArray);
    }
}
