package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年01月21日
 */
@Data
@Component
public class UserDTO {
    @NotBlank(message = "用户账号,不能为空")
    @ApiModelProperty(value = "用户账号", example = "", required = true, dataType = "String")
    private String userAccount;

    @NotBlank(message = "用户密码,不能为空")
    @ApiModelProperty(value = "用户密码", example = "", required = true, dataType = "String")
    private String userPassword;
}
