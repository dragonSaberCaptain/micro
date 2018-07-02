package com.jskj.micro.filter;

import com.jskj.micro.config.common.Global;
import com.jskj.micro.enums.UserEnum;
import com.jskj.micro.utils.ResultUtil;
import com.jskj.micro.utils.database.redis.JedisUtil;
import com.jskj.micro.utils.ip.IpUtil;
import com.jskj.micro.utils.safety.VerifyUtil;
import com.jskj.micro.utils.string.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.filter
 * @description
 * @date 2018-05-06 22:25 星期日
 */
public class ApiInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory
            .getLogger(ApiInterceptor.class);

    private Map<String, Object> getParams(HttpServletRequest request) {
        Map<String, String[]> rec    = request.getParameterMap();
        Map<String, Object>   result = new LinkedHashMap<String, Object>();

        for (Map.Entry<String, String[]> entry : rec.entrySet()) {
            String name  = entry.getKey();
            Object value = entry.getValue()[0];
            result.put(name, value);
            logger.info("请求参数:" + name + ", value:" + value);
        }
        return result;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        String url = httpServletRequest.getRequestURI();
        logger.info("请求地址： " + url);
        String ip = IpUtil.getIpAddress(httpServletRequest);
        logger.info("请求ip： " + ip);
        String agent = httpServletRequest.getHeader("User-Agent");
        logger.info("请求来源： " + agent);

        //判断是否开启debug模式
        if (Global.DEBUG) {
            return true;
        }
        if (!Global.OPTEN_TOKEN) {
            return true;
        }

        Map<String, Object> requestMap = getParams(httpServletRequest);

//        判断请求是否来自手机 返回true表示是手机
        boolean judgeismoblie = VerifyUtil.judgeIsMoblie(httpServletRequest);

        logger.info("是否来自手机:" + judgeismoblie);

        if (!judgeismoblie) {
            return true;
        }
        Map<String, Object> rec = new LinkedHashMap<>();

        String token   = (String) requestMap.get("token");
        String signMsg = (String) requestMap.get("signMsg");
        String uuid    = (String) requestMap.get("uuid");

        if (StringUtil.isBlank(token)) {
            rec.put(Global.CODE, UserEnum.TOKEN_NOT_EMPTY.getCode());
            rec.put(Global.MSG, UserEnum.TOKEN_NOT_EMPTY.getMsg());
            ResultUtil.writeJson(rec, httpServletResponse);
            return false;
        }
        //从缓存中获取token
        String webToken;
        try {
            webToken = JedisUtil.Strings.get(Global.LOGIN_VALID_TOKEN + token);
        } catch (Exception e) {
            logger.error("ApiInterceptor--preHandle", e);
            e.printStackTrace();
            rec.put(Global.CODE, UserEnum.TOKEN_NO_FIND.getCode());
            rec.put(Global.MSG, UserEnum.TOKEN_NO_FIND.getMsg());
            ResultUtil.writeJson(rec, httpServletResponse);
            return false;
        }
        //验证前端传入的token与后台存储的token是否一致
        if (StringUtil.isNotBlank(webToken)) {
            //验证流程
            String  webSignMsg = DigestUtils.md5Hex(Global.MD5_SALT + uuid).toUpperCase();
            boolean bool       = webSignMsg.equalsIgnoreCase(signMsg);
            if (bool) {
                logger.info("ApiInterceptor--preHandle", "验证通过");
                return true;
            }
        }

        rec.put(Global.CODE, UserEnum.TOKEN_ERROR.getCode());
        rec.put(Global.MSG, UserEnum.TOKEN_ERROR.getMsg());
        ResultUtil.writeJson(rec, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }
}
