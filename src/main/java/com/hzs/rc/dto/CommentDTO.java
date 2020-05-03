package com.hzs.rc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年05月02日
 */
@Data
public class CommentDTO {
    @ApiModelProperty(value = "id", example = "", required = false, dataType = "Integer")
    private Integer id;

    @NotBlank(message = "内容不能为空")
    @ApiModelProperty(value = "content", example = "", required = true, dataType = "String")
    private String content;

    @NotNull(message = "父类id用户不能为空")
    @ApiModelProperty(value = "parentId", example = "", required = true, dataType = "Integer")
    private Integer parentId;

    @NotNull(message = "评论类型不能为空,1为帖子评论2为评论的评论")
    @ApiModelProperty(value = "type", example = "", required = true, dataType = "Integer")
    private Integer type;

    @NotNull(message = "评论人id用户不能为空")
    @ApiModelProperty(value = "commentator", example = "", required = true, dataType = "Integer")
    private Integer commentator;
}
