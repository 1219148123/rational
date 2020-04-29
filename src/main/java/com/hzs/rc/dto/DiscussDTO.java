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
 * @Date 2020年04月24日
 */
@Data
public class DiscussDTO {
    @ApiModelProperty(value = "id", example = "", required = false, dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "author", example = "", required = false, dataType = "Integer")
    private Integer author;

    @ApiModelProperty(value = "帖子标题", example = "", required = true, dataType = "String")
    private String title;

    @ApiModelProperty(value = "帖子类别", example = "", required = true, dataType = "String")
    private String tag;

    @ApiModelProperty(value = "帖子内容", example = "", required = true, dataType = "String")
    private String description;
}
