package com.hzs.rc.vo;

import lombok.Data;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年02月18日
 */
@Data
public class AddressVO {
    private Integer id;

    private String province;

    private String city;

    private String county;

    private String specAddr;

    private String consignee;

    private String phone;
}
