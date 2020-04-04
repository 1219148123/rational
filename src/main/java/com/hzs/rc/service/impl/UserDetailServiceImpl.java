package com.hzs.rc.service.impl;

import com.hzs.rc.dto.UserDetailDTO;
import com.hzs.rc.entity.User;
import com.hzs.rc.entity.UserDetail;
import com.hzs.rc.mapper.UserDetailMapper;
import com.hzs.rc.service.UserDetailService;
import com.hzs.rc.vo.UserDetailVO;
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
    UserDetailMapper userDetailMapper;

    @Override
    public UserDetailVO getUserDetail(Integer userId) {
        return userDetailMapper.getUserDetail(userId);
    }

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
        UserDetail userDetail = new UserDetail();
        //把user对象userId给UserDetail对象
        BeanUtils.copyProperties(user,userDetail);
        userDetail.setUserCreateTime(new Date());
        return userDetailMapper.simpleInsertUserDetail(userDetail);
    }

    /**
     *@描述 用户登录后设置每月消费额度
     *@参数  [userDetailDTO]
     *@返回值  void
     *@创建人  hanzs
     *@创建时间  2020/2/13
     */
    @Override
    public void setUserPlantSpent(UserDetailDTO userDetailDTO) {
        userDetailMapper.setPlantSpent(userDetailDTO);
    }
    /**
     *@描述
     *@参数  [userDetailDTO]
     *@返回值  void
     *@创建人  hanzs
     *@创建时间  2020/2/13
     */
    @Override
    public void updateUserDetail(UserDetailDTO userDetailDTO) {
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(userDetailDTO,userDetail);
        userDetailMapper.updateUserDetail(userDetail);
    }

    @Override
    public void updateCurSpent(Integer userId, Double userCurrentSpent) {
        userDetailMapper.updateCurSpent(userId,userCurrentSpent);
    }
}
