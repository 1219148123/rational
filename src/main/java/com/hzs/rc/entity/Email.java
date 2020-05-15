package com.hzs.rc.entity;

import lombok.Data;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年05月15日
 */
@Data
public class Email {
    private String to;

    private String subject;

    private String content;
}
