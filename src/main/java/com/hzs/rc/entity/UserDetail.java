package com.hzs.rc.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
/**
 * @author hanzs
 * @version 1.0
 * @description: controller
 * @Date 2020年01月21日
 */
import java.util.Date;
@Component
@Data
public class UserDetail {
    private Integer id;

    private Integer userId;

    private String userName;

    private String sex;

    private String userEmail;

    private String userPhone;

    private Integer userAddressId;

    private Double userPlanSpent;

    private Double userCurrentSpent;

    private Date userCreateTime;
}