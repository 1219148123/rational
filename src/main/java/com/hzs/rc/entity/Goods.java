package com.hzs.rc.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Goods {
    private Integer goodId;

    private Integer storeId;

    private String goodName;

    private Float price;

    private Integer num;

    private Date updateTime;

    private Integer category;

    private String imgAddr;

    private String description;

    private Integer priority;

    private Integer goodStatus;
}