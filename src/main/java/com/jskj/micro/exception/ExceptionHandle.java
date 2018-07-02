package com.jskj.micro.exception;

import cn.jiguang.common.resp.APIRequestException;
import com.alibaba.fastjson.JSONException;
import com.jskj.micro.dto.ResultDto;
import com.jskj.micro.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.smart.exceptionHandle
 * @description 异常统一处理类
 * @date 2018-05-03 11:31 星期四
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultDto handle(RuntimeException e) {
        if (e instanceof UserException) {
            UserException e1 = (UserException) e;
            logger.error("【用户异常】", e1);
            return new ResultDto(e1.getCode(), e1.getMsg());
        }

        if (e instanceof JSONException) {
            JSONException e1 = (JSONException) e;
            logger.error("【json异常】", e1.fillInStackTrace());
            return new ResultDto(ResultEnum.JSON_ERROR);
        }

        if (e instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException e1 = (HttpMessageNotReadableException) e;
            logger.error("【http内容不可读异常】", e1);
            return new ResultDto(ResultEnum.HTTP_MESSAGE_NOT_READABLE);
        }
        if (e instanceof NullPointerException) {
            NullPointerException e1 = (NullPointerException) e;
            logger.error("【空指针异常】", e1);
            return new ResultDto(ResultEnum.NULL_POINTER);
        }
        if (e instanceof ClassCastException) {
            ClassCastException e1 = (ClassCastException) e;
            logger.error("【类型转换异常】", e1);
            return new ResultDto(ResultEnum.CLASS_CAST);
        }
        if (e instanceof IndexOutOfBoundsException) {
            IndexOutOfBoundsException e1 = (IndexOutOfBoundsException) e;
            logger.error("【下标越界异常】", e1);
            return new ResultDto(ResultEnum.INDEX_OUT_OF_BOUNDS);
        }
        logger.error("【运行时异常】", e);
        return new ResultDto(ResultEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDto handle(Exception e) {
        if (e instanceof APIRequestException) {
            APIRequestException e1 = (APIRequestException) e;
            logger.error("【极光推送异常】", e1);
            return new ResultDto(String.valueOf(e1.getErrorCode()), e1.getErrorMessage());
        }
        logger.error("【IO异常】", e);
        return new ResultDto(ResultEnum.IO_ABNORMAL);
    }

    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ResultDto handle(IOException e) {
        if (e instanceof FileNotFoundException) {
            FileNotFoundException e1 = (FileNotFoundException) e;
            logger.error("【文件路径异常】", e1);
            return new ResultDto(ResultEnum.FILE_PATH_ERROR);
        }
        logger.error("【IO异常】", e);
        return new ResultDto(ResultEnum.IO_ABNORMAL);
    }

    @ExceptionHandler(ServletException.class)
    @ResponseBody
    public ResultDto handle(ServletException e) {
        if (e instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException e1 = (MissingServletRequestParameterException) e;
            logger.error("【请求参数异常】", e1);
            return new ResultDto(ResultEnum.PARAMS_ERROR);
        }
        logger.error("【服务器内部异常】", e);
        return new ResultDto(ResultEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ReflectiveOperationException.class)
    @ResponseBody
    public ResultDto handle(ReflectiveOperationException e) {
        if (e instanceof NoSuchMethodException) {
            NoSuchMethodException e1 = (NoSuchMethodException) e;
            logger.error("【未知方法异常】", e1);
            return new ResultDto(ResultEnum.NO_SUCH_METHOD);
        }
        logger.error("【服务器内部异常】", e);
        return new ResultDto(ResultEnum.INTERNAL_SERVER_ERROR);
    }
}
