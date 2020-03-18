package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月18日
 */
@Data
public class GoodsDTO {
    @ApiModelProperty(value = "storeId", example = "", required = false, dataType = "Integer")
    private Integer goodId;

    @ApiModelProperty(value = "店铺id", example = "", required = false, dataType = "String")
    private Integer storeId;

    @NotBlank(message = "商品名称,不能为空")
    @ApiModelProperty(value = "商品名称", example = "", required = true, dataType = "String")
    private String goodName;

    @NotNull(message = "商品价格,不能为空")
    @ApiModelProperty(value = "商品价格", example = "", required = true, dataType = "Float")
    private Float price;

    @NotNull(message = "商品库存,不能为空")
    @ApiModelProperty(value = "商品库存", example = "", required = true, dataType = "Integer")
    private Integer num;

    @NotNull(message = "商品类别,不能为空")
    @ApiModelProperty(value = "商品类别", example = "", required = true, dataType = "Integer")
    private Integer category;

    @NotBlank(message = "商品描述,不能为空")
    @ApiModelProperty(value = "商品描述", example = "", required = true, dataType = "String")
    private String description;

    @ApiModelProperty(value = "商品优先级", example = "", required = false, dataType = "Integer")
    private Integer priority;
}
