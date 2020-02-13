package com.hzs.rc.entity;

import lombok.Data;

/**
 * @author hanzs
 * @version 1.0
 * @description: controller
 * @Date 2020年01月21日
 */
@Data
public class User {

    private Integer userId;

    private String userAccount;

    private String userPassword;

    private String stateCode;

}