package com.hzs.rc.mapper;

import com.hzs.rc.dto.PasswordDTO;
import com.hzs.rc.entity.User;

public interface UserMapper {
    //用户注册
    int insertUser(User record);

    //获取原始密码
    String getUserOldPassword(Integer userId);

    //修改密码
    void updatePassword(PasswordDTO passwordDTO);
}