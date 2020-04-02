package com.hzs.rc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月25日
 */
@Data
public class UserDetailVO {
    private Integer id;

    private Integer userId;

    private String userName;

    private String sex;

    private String userEmail;

    private String userPhone;

    private Integer userAddressId;

    private Double userPlanSpent;

    private Double userCurrentSpent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date userCreateTime;

    private Long openStore;
}
