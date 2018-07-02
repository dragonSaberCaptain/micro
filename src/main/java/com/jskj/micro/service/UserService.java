package com.jskj.micro.service;

import com.github.pagehelper.PageInfo;
import com.jskj.micro.model.micro.MUser;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.micro.service
 * //TODO
 * @date 2018-06-27 10:34 星期三
 */
public interface UserService {
    int deleteByPrimaryKey(Long id);

    MUser insertSelective(MUser record);

    MUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MUser record);

    List<MUser> selectBySelective(MUser record);

    PageInfo<MUser> selectBySelective(MUser record, int pageNum, int pageSize);

    MUser login(String mobile, String code, String equipmentNumber);

}
