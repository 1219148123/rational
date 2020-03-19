package com.hzs.rc.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Cart {
    private Integer id;

    private Integer userId;

    private Integer goodId;

    private Integer quantity;

    private Integer checked;

    private Date createTime;

    private Date updateTime;
}