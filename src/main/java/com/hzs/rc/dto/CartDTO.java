package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月19日
 */
@Data
public class CartDTO {
    @ApiModelProperty(value = "id", example = "", required = false, dataType = "Integer")
    private Integer id;

    @NotNull(message = "当前登录用户不能为空")
    @ApiModelProperty(value = "userId", example = "", required = true, dataType = "Integer")
    private Integer userId;

    @NotNull(message = "商品id不能为空")
    @ApiModelProperty(value = "goodId", example = "", required = true, dataType = "Integer")
    private Integer goodId;

    @NotNull(message = "商品数量不能为空")
    @ApiModelProperty(value = "storeId", example = "", required = true, dataType = "Integer")
    private Integer quantity;
}
