package com.hzs.rc.service.impl;

import com.hzs.rc.entity.Email;
import com.hzs.rc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年05月15日
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendSimpleMail(Email email) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom("1219148123@qq.com");
        //邮件接收人
        message.setTo(email.getTo());
        //邮件主题
        message.setSubject(email.getSubject());
        //邮件内容
        message.setText(email.getContent());
        //发送邮件
        mailSender.send(message);
    }
}
