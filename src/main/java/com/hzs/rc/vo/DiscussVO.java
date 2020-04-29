package com.hzs.rc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hzs.rc.entity.UserDetail;
import lombok.Data;

import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年04月24日
 */
@Data
public class DiscussVO {
    private Integer id;

    private String title;

    private UserDetail userDetail;

    private String tag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModified;

    private Integer likeCount;

    private Integer commentCount;

    private Integer viewCount;

    private String description;

    private String stateCode;
}
