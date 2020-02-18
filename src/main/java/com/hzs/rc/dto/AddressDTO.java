package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年02月18日
 */
@Data
public class AddressDTO {
    @ApiModelProperty(value = "id", example = "", required = true, dataType = "String")
    private Integer id;
    @ApiModelProperty(value = "省份", example = "", required = true, dataType = "String")
    private String province;

    @ApiModelProperty(value = "城市", example = "", required = true, dataType = "String")
    private String city;

    @ApiModelProperty(value = "乡镇", example = "", required = true, dataType = "String")
    private String county;

    @ApiModelProperty(value = "具体地址", example = "", required = true, dataType = "String")
    private String specAddr;

    @NotBlank(message = "收货人不能为空")
    private String consignee;
    @NotBlank(message = "收获人联系电话不能为空")
    private String phone;
}
