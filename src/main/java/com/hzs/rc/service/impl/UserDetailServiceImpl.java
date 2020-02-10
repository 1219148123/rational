package com.hzs.rc.service.impl;

import com.hzs.rc.entity.User;
import com.hzs.rc.entity.UserDetail;
import com.hzs.rc.mapper.UserDetailMapper;
import com.hzs.rc.service.UserDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年01月21日
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Resource
    UserDetail userDetail;
    @Resource
    UserDetailMapper userDetailMapper;
    /**
     *@描述  注册的同时,插入到UserDetail表,插入createTime、userId即可
     *@参数  [userDetail]
     *@返回值  java.lang.Integer
     *@创建人  hanzs
     *@创建时间  2020/1/21
     */
    @Transactional
    @Override
    public Integer insertUserDetailForSignUp(User user) {
        //把user对象userId给UserDetail对象
        BeanUtils.copyProperties(user,userDetail);
        userDetail.setUserCreateTime(new Date());
        return userDetailMapper.simpleInsertUserDetail(userDetail);
    }
}
