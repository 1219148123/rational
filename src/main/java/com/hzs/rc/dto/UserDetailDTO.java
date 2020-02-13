package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年01月21日
 */
@Data
public class UserDetailDTO {
    @ApiModelProperty(value = "用户主键", example = "", required = true, dataType = "Integer")
    private Integer userId;

    @ApiModelProperty(value = "用户名", example = "", required = false, dataType = "Integer")
    private String userName;

    @ApiModelProperty(value = "用户性别", example = "", required = false, dataType = "Integer")
    private String sex;

    @ApiModelProperty(value = "用户邮箱", example = "", required = false, dataType = "Integer")
    private String userEmail;

    @ApiModelProperty(value = "用户电话", example = "", required = false, dataType = "Integer")
    private String userPhone;

    @ApiModelProperty(value = "用户计划每月消费额度", example = "", required = false, dataType = "Integer")
    private Double userPlanSpent;
}
