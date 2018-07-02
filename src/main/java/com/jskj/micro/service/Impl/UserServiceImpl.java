package com.jskj.micro.service.Impl;

import cn.jsms.api.ValidSMSResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.micro.config.common.Global;
import com.jskj.micro.dao.MUserDAO;
import com.jskj.micro.enums.UserEnum;
import com.jskj.micro.exception.UserException;
import com.jskj.micro.model.micro.MUser;
import com.jskj.micro.service.UserService;
import com.jskj.micro.utils.database.redis.JedisUtil;
import com.jskj.micro.utils.jpush.JpushSMSUtil;
import com.jskj.micro.utils.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.micro.service.Impl
 * //TODO
 * @date 2018-06-27 11:01 星期三
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private MUserDAO mUserDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mUserDAO.deleteByPrimaryKey(id);
    }

    @Override
    public MUser insertSelective(MUser record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        int num = mUserDAO.insertSelective(record);
        if (num > 0) {
            return record;
        }
        return null;
    }

    @Override
    public MUser selectByPrimaryKey(Long id) {
        return mUserDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MUser record) {
        return mUserDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<MUser> selectBySelective(MUser record) {
        return mUserDAO.selectBySelective(record);
    }

    @Override
    public PageInfo<MUser> selectBySelective(MUser record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<MUser> mUsers = mUserDAO.selectBySelective(record);
        return new PageInfo<>(mUsers);
    }

    @Override
    public MUser login(String mobile, String code, String equipmentNumber) {
        MUser mUser = new MUser();
        mUser.setMobile(mobile);
        List<MUser> mUsers = mUserDAO.selectBySelective(mUser);
        if (mUsers.size() == 0) {
            if (StringUtil.isBlank(equipmentNumber)) {
                logger.error("注册时手机设备号不能为空");
                throw new UserException(UserEnum.EQUIPMENT_NUMBER_NOT_EMPTY);
            }
            mUser.setEquipmentNumber(equipmentNumber);
            mUser = insertSelective(mUser);
            mUsers.add(mUser);
        } else if (mUsers.size() > 1) {
            logger.error("手机号不唯一");
            throw new UserException(UserEnum.MOBILE_NOT_UNIQUE);
        } else if (mUsers.get(0).getIsDelete().equals(Global.ONE_STRING)) {
            logger.error("用户已删除");
            throw new UserException(UserEnum.DELETED);
        }

        boolean bool = false;
        if (Global.DEBUG) {
            bool = true;
        } else {
            String msgId = JedisUtil.Strings.get(Global.APPLICATION_NAME + mobile + ":msgId");
            logger.info("从缓存中获取msgid:" + msgId);
            if (StringUtil.isBlank(msgId)) {
                logger.error("验证码已超时");
                throw new UserException(UserEnum.VERIFICATION_CODE_TIMEOUT);
            }
            try {
                logger.info("发送验证信息判断验证码是否正确");
                ValidSMSResult validSMSResult = JpushSMSUtil.sendValidSMSCode(msgId, code);
                if (validSMSResult != null) {
                    bool = validSMSResult.getIsValid();
                }
            } catch (Exception e) {
                logger.error("验证码不正确");
                throw new UserException(UserEnum.VERIFICATION_FAILURE);
            }
        }
        if (bool) {
            return mUsers.get(0);
        }
        return null;
    }
}
