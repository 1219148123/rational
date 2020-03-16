package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月16日
 */
@Data
public class CategoryDTO {
    @ApiModelProperty(value = "cateName", example = "", required = true, dataType = "String")
    private String cateName;
}
