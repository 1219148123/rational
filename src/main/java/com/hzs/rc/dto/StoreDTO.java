package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月10日
 */
@Data
@ToString
public class StoreDTO {
    @ApiModelProperty(value = "storeId", example = "", required = false, dataType = "Integer")
    private Integer storeId;

    @NotBlank(message = "店铺名称,不能为空")
    @ApiModelProperty(value = "店铺名称", example = "", required = true, dataType = "String")
    private String storeName;

    @ApiModelProperty(value = "店铺描述", example = "", required = true, dataType = "String")
    private String storeDesc;

    @NotNull(message = "店铺类别,不能为空")
    @ApiModelProperty(value = "店铺类别", example = "", required = true, dataType = "Integer")
    private Integer storeCate;
}
