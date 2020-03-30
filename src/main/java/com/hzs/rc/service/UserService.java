package com.hzs.rc.service;

import com.hzs.rc.dto.PasswordDTO;
import com.hzs.rc.dto.UserDTO;
import com.hzs.rc.entity.User;

/**
 * <p>UserService接口</p>
 *
 * @author :  hzs 2020年01月21日
 * @version : 1.0
 */
public interface UserService {
    Integer login(UserDTO userDTO);

    Integer userSignUp(UserDTO userDTO);

    Integer rePassword(PasswordDTO passwordDTO);
}

