package com.hzs.rc.controller.admin;

import com.hzs.rc.entity.Email;
import com.hzs.rc.service.EmailService;
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
 * @description: entity
 * @Date 2020年05月15日
 */
@RestController
@RequestMapping("/email")
public class EmailController {
    @Resource
    EmailService emailService;

    @ApiOperation(value = "发送邮件", notes = "发送邮件")
    @PostMapping("/sent")
    public void insertAdmin(@Valid @RequestBody Email email) {
        emailService.sendSimpleMail(email);
    }
}
