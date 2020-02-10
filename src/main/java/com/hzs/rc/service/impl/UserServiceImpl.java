package com.hzs.rc.service.impl;

import com.hzs.rc.dto.UserDTO;
import com.hzs.rc.entity.User;
import com.hzs.rc.mapper.UserMapper;
import com.hzs.rc.service.UserDetailService;
import com.hzs.rc.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author hanzs
 * @version 1.0
 * @description: serviceImpl
 * @Date 2020年01月21日
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    User user;
    @Resource
    UserMapper userMapper;
    int flag = 0;
    @Resource
    UserDetailService userDetailService;
    /**
     * @描述 用户快速注册,只需要填写账号密码即可注册
     * @参数 [user]
     * @返回值 java.lang.Integer
     * @创建人 hanzs
     * @创建时间 2020/1/21
     */
    @Transactional
    @Override
    public Integer userSignUp(UserDTO userDTO) {
        BeanUtils.copyProperties(userDTO,user);
        flag = userMapper.insertUser(user);
        userDetailService.insertUserDetailForSignUp(user);
        return flag;
    }
}
