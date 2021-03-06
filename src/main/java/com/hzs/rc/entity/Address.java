package com.hzs.rc.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {
    private Integer id;

    private Integer userId;

    private String province;

    private String city;

    private String county;

    private String specAddr;

    private String consignee;

    private String phone;

}