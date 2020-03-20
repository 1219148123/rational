package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月20日
 */
@Data
public class OrderDTO {
    @ApiModelProperty(value = "用户id", example = "", required = false, dataType = "Integer")
    private Integer userId;

    @ApiModelProperty(value = "地址id", example = "", required = true, dataType = "Integer")
    private Integer addressId;
}
