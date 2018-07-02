package com.jskj.micro.utils.safety;

import com.jskj.micro.config.common.Global;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils
 * @description 安全相关工具类
 * @date 2018-05-07 16:54 星期一
 */
public class VerifyUtil {
    /**
     * 对字符串处理:将指定位置到指定位置的字符以星号代替
     *
     * @param content 传入的字符串
     * @param begin   开始位置
     * @param end     结束位置
     * @return
     */
    public static String getStarString(String content, int begin, int end) {

        if (begin >= content.length() || begin < 0) {
            return content;
        }
        if (end >= content.length() || end < 0) {
            return content;
        }
        if (begin >= end) {
            return content;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = begin; i < end; i++) {
            stringBuilder.append("*");
        }
        String starStr = stringBuilder.toString();
        return content.substring(0, begin) + starStr
                + content.substring(end, content.length());
    }


    /**
     * 对字符加星号处理：除前面几位和后面几位外，其他的字符以星号代替
     *
     * @param content  传入的字符串
     * @param frontNum 保留前面字符的位数
     * @param endNum   保留后面字符的位数
     * @return 带星号的字符串
     */

    public static String getStarString2(String content, int frontNum,
                                        int endNum) {

        if (frontNum >= content.length() || frontNum < 0) {
            return content;
        }
        if (endNum >= content.length() || endNum < 0) {
            return content;
        }
        if (frontNum + endNum >= content.length()) {
            return content;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < (content.length() - frontNum - endNum); i++) {
            stringBuilder.append("*");
        }
        String starStr = stringBuilder.toString();
        return content.substring(0, frontNum)
                + starStr
                + content
                .substring(content.length() - endNum, content.length());

    }


    /**
     * [身份证号] 9527****9528，前面保留4位明文，后面保留4位明文  中间部分用4个星号代替
     *
     * @param idNumber
     * @return
     */
    public static String idDesensitization(String idNumber) {
        if (StringUtils.isBlank(idNumber)) {
            return "";
        }
        return StringUtils.left(idNumber, 4) + "****" + StringUtils.right(idNumber, 4);
    }

    /**
     * [手机号码] 前三位，后四位，其他隐藏<例子:138****1234>
     *
     * @param mobile
     * @return
     */
    public static String mobileDesensitization(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return "";
        }
        return StringUtils.left(mobile, 3) + "****" + StringUtils.right(mobile, 4);
    }

    /**
     * 判断是否为手机浏览器
     *
     * @param request
     * @return true 是，false 不是
     * @author dragonSaberCaptain
     * @date 2018-05-22 14:53:48
     */
    public static boolean judgeIsMoblie(HttpServletRequest request) {
        boolean isMoblie = false;
        String[] mobileAgents = {"iphone", "android", "ipad", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
                "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
                "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
                "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
                "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
                "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
                "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
                "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
                "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
                "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
                "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
                "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
                "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
                "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-", "okhttp",
                "Googlebot-Mobile"};
        if (request.getHeader(Global.USER_AGENT) != null) {
            String agent = request.getHeader(Global.USER_AGENT);
            for (String mobileAgent : mobileAgents) {
                if (agent.toLowerCase().indexOf(mobileAgent) >= 0 && agent.toLowerCase().indexOf("windows nt") <= 0 && agent.toLowerCase().indexOf("macintosh") <= 0) {
                    isMoblie = true;
                    break;
                }
            }
        }
        return isMoblie;
    }
}
