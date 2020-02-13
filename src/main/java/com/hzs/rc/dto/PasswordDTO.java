package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年02月13日
 */
@Data
@ToString
public class PasswordDTO {
    @ApiModelProperty(value = "用户主键", example = "", required = true, dataType = "Integer")
    private Integer userId;

    @ApiModelProperty(value = "用户原始密码", example = "", required = true, dataType = "String")
    private String nowPassword;

    @ApiModelProperty(value = "用户新密码", example = "", required = true, dataType = "String")
    private String newPassword;
}
