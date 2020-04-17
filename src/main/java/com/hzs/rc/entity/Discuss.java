package com.hzs.rc.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Discuss {
    private Integer id;

    private String title;

    private String tag;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer likeCount;

    private Integer commentCount;

    private Integer viewCount;

    private String description;
}