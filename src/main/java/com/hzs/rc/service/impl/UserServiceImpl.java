package com.hzs.rc.service.impl;

import com.hzs.rc.dto.PasswordDTO;
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
    UserMapper userMapper;
    int flag = 0;
    @Resource
    UserDetailService userDetailService;

    @Override
    public Integer login(UserDTO userDTO) {
        User login = new User();
        BeanUtils.copyProperties(userDTO,login);
        User user = userMapper.login(login);
        if (user == null){
            return 0;//账号不存在
        }else if(user.getUserPassword().equals(userDTO.getUserPassword())) {
            return user.getUserId();
        }
        return -1;//账号密码匹配失败
    }

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
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        flag = userMapper.insertUser(user);
        userDetailService.insertUserDetailForSignUp(user);
        return flag;
    }
    /**
     *@描述   用户修改密码接口
     *@参数  PasswordDTO 用户密码DTO
     *@返回值  Integer 1.为原始密码输入错误 2.新密码和旧密码相同 3.修改密码成功
     *@创建人  hanzs
     *@创建时间  2020/2/13
     */
    @Transactional
    @Override
    public Integer rePassword(PasswordDTO passwordDTO) {
        System.out.println(passwordDTO);
        //原始密码错误
        String oldPw = userMapper.getUserOldPassword(passwordDTO.getUserId());
        System.out.println(oldPw);
        System.out.println(passwordDTO.getNowPassword());
        System.out.println(passwordDTO.getNowPassword().equals(oldPw));
        if(!(passwordDTO.getNowPassword().equals(oldPw))) {
            return 1;
        }
        //新密码是否和旧密码相同
        if (passwordDTO.getNewPassword().equals(oldPw)){
            return 2;
        }
        //修改密码为新密码
        userMapper.updatePassword(passwordDTO);
        return 3;
    }
}
