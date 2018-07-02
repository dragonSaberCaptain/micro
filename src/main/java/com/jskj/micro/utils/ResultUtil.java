package com.jskj.micro.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jskj.micro.config.common.Global;
import com.jskj.micro.enums.ResultEnum;
import com.jskj.micro.enums.UserEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils
 * @description
 * @date 2018-05-07 14:13 星期一
 */
public class ResultUtil {
    private static final Logger       logger = LoggerFactory.getLogger(ResultUtil.class);
    private static       ObjectMapper mapper = new ObjectMapper();

    public static void writeJson(Object obj, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf8");
            PrintWriter pw = resp.getWriter();
            String      str;
            if (!(obj instanceof String)) {
                str = toString(obj);
            } else {
                str = obj.toString();
            }
            pw.print(str);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void writeJson(Object obj, Object data, HttpServletResponse resp) {
        Map<String, Object> rec = new LinkedHashMap<>();
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf8");
            PrintWriter pw = resp.getWriter();
            String      str;
            if (obj instanceof String) {
                str = obj.toString();
            } else {
                if (obj instanceof UserEnum) {
                    UserEnum userEnum = (UserEnum) obj;
                    rec.put(Global.CODE, userEnum.getCode());
                    rec.put(Global.MSG, userEnum.getMsg());
                    rec.put(Global.DATA, data);
                    str = rec.toString();
                } else if (obj instanceof ResultEnum) {
                    ResultEnum videoEnum = (ResultEnum) obj;
                    rec.put(Global.CODE, videoEnum.getCode());
                    rec.put(Global.MSG, videoEnum.getMsg());
                    rec.put(Global.DATA, data);
                    str = rec.toString();
                } else {
                    str = toString(obj);
                }
            }
            pw.print(str);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static String toString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
