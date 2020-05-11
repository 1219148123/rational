package com.hzs.rc.mapper;

import com.hzs.rc.dto.PasswordDTO;
import com.hzs.rc.dto.UserDTO;
import com.hzs.rc.entity.User;

public interface UserMapper {
    //用户注册
    int insertUser(User record);

    //登录验证
    User login(User user);
    //获取原始密码
    String getUserOldPassword(Integer userId);

    //修改密码
    void updatePassword(PasswordDTO passwordDTO);

    //状态修改为开店(管理员审核的时候设置)
    void openStore(Integer userId);

    //用户注销
    void  invalidUser(Integer userId);

    void activeUser(Integer userId);
}