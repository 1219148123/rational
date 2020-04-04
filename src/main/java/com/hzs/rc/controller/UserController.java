package com.hzs.rc.controller;

import com.hzs.rc.dto.PasswordDTO;
import com.hzs.rc.dto.UserDTO;
import com.hzs.rc.dto.UserDetailDTO;
import com.hzs.rc.service.UserDetailService;
import com.hzs.rc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;

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

    @ApiOperation(value = "获取session中的用户", notes = "获取session中的用户")
    @PostMapping(value = "/getUser")
    public Object getUser(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        return session.getAttribute("hzsUser");
    }

    @ApiOperation(value = "销毁session", notes = "销毁session")
    @PostMapping(value = "/inLogin")
    public void inLogin(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
         session.invalidate();
    }

    @ApiOperation(value = "用户登录", notes = "账户密码登录")
    @PostMapping(value = "/login")
    public Object login(@Valid @RequestBody UserDTO userDTO, HttpServletRequest httpServletRequest) {
        Integer res = userService.login(userDTO);
        if (res != 0 && res != -1) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("hzsUser", userDetailService.getUserDetail(res));
            return 1;
        }
        return res;
    }


    @ApiOperation(value = "添加用户", notes = "根据参数添加用户")
    @PostMapping(value = "/userSignUp")
    public Integer userSignUp(@Valid @RequestBody UserDTO userDTO) {
        return userService.userSignUp(userDTO);
    }

    @ApiOperation(value = "完善用户信息", notes = "根据参数完善用户信息")
    @PostMapping(value = "/updateUser")
    public void uerUpdate(@Valid @RequestBody UserDetailDTO userDetailDTO, HttpServletRequest httpServletRequest) {
        userDetailService.updateUserDetail(userDetailDTO);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("hzsUser", userDetailService.getUserDetail(userDetailDTO.getUserId()));
    }

    @ApiOperation(value = "修改用户密码", notes = "填写旧密码新密码修改密码")
    @PostMapping(value = "/updatePassword")
    public Integer setPassword(@Valid @RequestBody PasswordDTO passwordDTO) {
        int result = userService.rePassword(passwordDTO);
        return result;
    }

    @ApiOperation(value = "修改用户本月花费", notes = "")
    @PostMapping(value = "/updateSpent")
    public void updateSpent(@RequestParam("userId") String userId,@RequestParam("spent") Double spent, HttpServletRequest httpServletRequest) {
         userDetailService.updateCurSpent(Integer.valueOf(userId),spent);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("hzsUser", userDetailService.getUserDetail(Integer.valueOf(userId)));
    }

    @ApiOperation(value = "设置本月消费额度", notes = "设置本月消费额度")
    @PostMapping(value = "/setPlantSpent")
    public void setPlantSpent(@Valid @RequestBody UserDetailDTO userDetailDTO) {
        userDetailService.setUserPlantSpent(userDetailDTO);
    }
}
