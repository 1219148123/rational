package com.hzs.rc.controller;

import com.hzs.rc.dto.PasswordDTO;
import com.hzs.rc.dto.UserDTO;
import com.hzs.rc.dto.UserDetailDTO;
import com.hzs.rc.service.UserDetailService;
import com.hzs.rc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author hanzs
 * @version 1.0
 * @description: controller
 * @Date 2020年01月21日
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户模块")
public class UserController {
    @Resource
    UserService userService;

    @Resource
    UserDetailService userDetailService;

    @ApiOperation(value = "添加用户", notes = "根据参数添加用户")
    @PostMapping(value = "/userSignUp")
    public Integer userSignUp(@Valid @RequestBody UserDTO userDTO) {
        return userService.userSignUp(userDTO);
    }

    @ApiOperation(value = "完善用户信息", notes = "根据参数完善用户信息")
    @PostMapping(value = "/updateUser")
    public void uerUpdate(@Valid @RequestBody UserDetailDTO userDetailDTO) {
        userDetailService.updateUserDetail(userDetailDTO);
    }

    @ApiOperation(value = "修改用户密码", notes = "填写旧密码新密码修改密码")
    @PostMapping(value = "/updatePassword")
    public Integer setPassword(@Valid @RequestBody PasswordDTO passwordDTO) {
       int result =  userService.rePassword(passwordDTO);
       return result;
    }

    @ApiOperation(value = "设置本月消费额度", notes = "设置本月消费额度")
    @PostMapping(value = "/setPlantSpent")
    public void setPlantSpent(@Valid @RequestBody UserDetailDTO userDetailDTO) {
        userDetailService.setUserPlantSpent(userDetailDTO);
    }
}
