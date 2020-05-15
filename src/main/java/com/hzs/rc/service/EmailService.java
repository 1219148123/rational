package com.hzs.rc.service;

import com.hzs.rc.entity.Email;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年05月15日
 * @version : 1.0
 */
public interface EmailService {
    void sendSimpleMail(Email email);
}
