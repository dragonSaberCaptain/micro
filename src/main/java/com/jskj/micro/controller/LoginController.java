package com.jskj.micro.controller;

import cn.jsms.api.SendSMSResult;
import com.jskj.micro.config.common.Global;
import com.jskj.micro.config.jpush.JpushConfig;
import com.jskj.micro.dto.UserDto;
import com.jskj.micro.enums.UserEnum;
import com.jskj.micro.model.micro.MUser;
import com.jskj.micro.service.UserService;
import com.jskj.micro.utils.database.redis.JedisUtil;
import com.jskj.micro.utils.jpush.JpushSMSUtil;
import com.jskj.micro.vo.user.UserFindVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.micro.controller
 * //TODO
 * @date 2018-06-27 11:17 星期三
 */
@Controller
@Api(value = "LoginController API", description = "登陆与注册相关接口")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    @GetMapping("/open/getLoginCode")
    @ApiOperation(value = "获取短信验证码", notes = "通过用户手机号获取短信验证码")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1005, message = "手机号不存在"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserDto getLoginCode(
            @RequestParam(name = "mobile") String mobile) throws Exception {
        if (Global.DEBUG) {
            return new UserDto(UserEnum.OK);
        }
        SendSMSResult sendSMSResult = JpushSMSUtil.sendSMSCode(mobile, JpushConfig.TEMPLD);
        logger.info("发送短信验证码:" + sendSMSResult.toString());

        JedisUtil.Strings.setEx(Global.APPLICATION_NAME + mobile + ":msgId", sendSMSResult.getMessageId(), 90);
        logger.info("存储msgId并设置有效期:" + mobile + ":msgId", sendSMSResult.getMessageId());
        return new UserDto(UserEnum.OK);
    }

    @GetMapping("/open/login")
    @ApiOperation(value = "登陆", notes = "验证用户是否存在，验证码是否正确")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 1006, message = "验证码已超时"),
            @ApiResponse(code = 1007, message = "验证未通过,验证码不正确"),
            @ApiResponse(code = 1004, message = "用户不存在"),
            @ApiResponse(code = 1010, message = "用户已删除"),
            @ApiResponse(code = 2003, message = "用户第一次登陆时设备号不能为空"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserDto<UserFindVo> login(
            @RequestParam(name = "mobile") String mobile,
            @RequestParam(name = "code") String code,
            @RequestParam(name = "equipmentNumber", required = false) String equipmentNumber) {
        MUser mUser = userService.login(mobile, code, equipmentNumber);
        if (mUser != null) {
            return new UserDto<>(UserEnum.OK, UserFindVo.daoToVo(mUser));
        }
        return new UserDto<>(UserEnum.FAIL);
    }
}
