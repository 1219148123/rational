package com.hzs.rc.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Comment {
    private Integer id;

    private Integer parentId;

    private String content;

    private Integer type;

    private Integer commentator;

    private Date createTime;

    private Integer likeCount;
}