package com.hzs.rc.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author hanzs
 * @version 1.0
 * @description: controller
 * @Date 2020年01月21日
 */
@Component
@Data
public class Address {
    private Integer id;

    private Integer userId;

    private String province;

    private String city;

    private String county;

    private String specAddr;

}