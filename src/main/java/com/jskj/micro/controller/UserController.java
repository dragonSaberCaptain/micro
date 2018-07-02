package com.jskj.micro.controller;

import cn.jpush.api.push.PushResult;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.micro.config.common.Global;
import com.jskj.micro.dao.MUserDAO;
import com.jskj.micro.dto.ResultDto;
import com.jskj.micro.dto.UserDto;
import com.jskj.micro.enums.ResultEnum;
import com.jskj.micro.enums.UserEnum;
import com.jskj.micro.exception.UserException;
import com.jskj.micro.model.micro.MUser;
import com.jskj.micro.service.UserService;
import com.jskj.micro.utils.database.redis.JedisUtil;
import com.jskj.micro.utils.jpush.JpushClientUtil;
import com.jskj.micro.utils.string.StringUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.controller
 * //TODO
 * @date 2018-06-05 14:42 星期二
 */
@Controller
@Api(value = "UserController API", description = "用户相关接口")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private MUserDAO mUserDAO;

    @DeleteMapping("/user/deleteById")
    @ApiOperation(value = "删除用户(永久)", notes = "根据ID删除用户,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto deleteById(@RequestParam(value = "id") Long id) {
        int num = userService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultDto(ResultEnum.OK);
        }
        return new ResultDto(ResultEnum.FAIL);
    }

    @PutMapping("/user/addByParams")
    @ApiOperation(value = "添加用户(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<MUser> addByParams(@ApiParam(name = "用户对象 ", value = "传入json格式") MUser record) {
        MUser mUser = userService.insertSelective(record);
        if (mUser != null) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/user/findById")
    @ApiOperation(value = "获取用户", notes = "根据ID查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<MUser> findById(@RequestParam(value = "id") Long id) {
        MUser record = userService.selectByPrimaryKey(id);
        if (record != null) {
            return new ResultDto<>(ResultEnum.OK, record);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/user/findByParams")
    @ApiOperation(value = "获取用户(按条件分页)", notes = "根据条件查询并分页")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PageInfo<MUser>> findByParams(@RequestParam(value = "searchParams", required = false) String searchParams,
                                                   @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                                   @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {

        MUser record = JSON.parseObject(searchParams, MUser.class);

        PageInfo<MUser> pPicturesPageInfo = userService.selectBySelective(record, pageNum, pageSize);
        if (pPicturesPageInfo.getSize() > 0) {
            return new ResultDto<>(ResultEnum.OK, pPicturesPageInfo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @PostMapping("/user/updateByParams")
    @ApiOperation(value = "更新用户(按条件)", notes = "根据ID修改对应字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<MUser> updateByParams(@ApiParam(name = "用户对象 ", value = "传入json格式") MUser record) {
        int num = userService.updateByPrimaryKeySelective(record);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/user/logout")
    @ApiOperation(value = "退出登录", notes = "清空当前用户token")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserDto logout(@RequestParam(name = "token") String token) {
        Long result = JedisUtil.Keys.del(Global.LOGIN_VALID_TOKEN + token);
        if (result > 0) {
            return new UserDto(UserEnum.OK);
        }
        return new UserDto(UserEnum.FAIL);
    }

    @PostMapping(value = "/user/pushMessageToAndroid")
    @ApiOperation(value = "推送消息", notes = "通过别称推送消息到安卓平台")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserDto pushMessageToAndroid(@RequestParam(name = "titleName") String titleName,
                                        @RequestParam(name = "msg") String msg,
                                        @RequestParam(name = "uid") String uid,
                                        @RequestParam(name = "type") String type,
                                        @RequestParam(name = "mobile", required = false) String mobile,
                                        @RequestParam(name = "roomNum", required = false) String roomNum,
                                        @RequestParam(name = "frontCamara", required = false) String frontCamara) throws Exception {

        MUser mUser;
        mUser = new MUser();
        mUser.setMobile(mobile);

        List<MUser> mUsers = userService.selectBySelective(mUser);
        if (mUsers.size() == 0) {
            throw new UserException(UserEnum.NOT_FOUND);
        }
        String              toAlias = mUsers.get(0).getId().toString();
        Map<String, String> extras  = new HashMap<>(16);

        if (StringUtil.isNotBlank(type)) {
            extras.put("type", type);
        }
        if (StringUtil.isNotBlank(titleName)) {
            extras.put("titleName", titleName);
        }
        if (StringUtil.isNotBlank(msg)) {
            extras.put("msg", msg);
        }
        if (StringUtil.isNotBlank(uid)) {
            extras.put("uid", uid);
        }
        if (StringUtil.isNotBlank(mobile)) {
            extras.put("mobile", mobile);
        }
        if (StringUtil.isNotBlank(roomNum)) {
            extras.put("roomNum", roomNum);
        }
        if (StringUtil.isNotBlank(frontCamara)) {
            extras.put("frontCamara", frontCamara);
        }

        PushResult pushResult;
        if (extras.size() == 0) {
            pushResult = JpushClientUtil.sendAndroidMessageWithAlias(titleName, JSON.toJSONString(extras), toAlias);
        } else {
            pushResult = JpushClientUtil.sendAndroidMessageWithAlias(titleName, JSON.toJSONString(extras), extras, toAlias);
        }
        if (pushResult != null) {
            return new UserDto(UserEnum.OK);
        }
        return new UserDto(UserEnum.FAIL);
    }
}
