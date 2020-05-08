package com.hzs.rc.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author hanzs
 * @version 1.0
 * @description: controller
 * @Date 2020年01月21日
 */
@Data
public class Admin {
    private Integer id;

    private String adminAccount;

    private String adminPassword;
}