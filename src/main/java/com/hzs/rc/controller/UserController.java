package com.hzs.rc.controller;

import com.hzs.rc.dto.UserDTO;
import com.hzs.rc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hanzs
 * @version 1.0
 * @description: controller
 * @Date 2020年01月21日
 */
@RestController
@RequestMapping("/hzs")
@Api(value = "用户模块")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation(value = "添加用户", notes = "根据参数添加用户")
    @PostMapping(value = "/userSignUp")
    public Integer userSignUp(@RequestBody UserDTO userDTO) {
        return userService.userSignUp(userDTO);
    }
}
