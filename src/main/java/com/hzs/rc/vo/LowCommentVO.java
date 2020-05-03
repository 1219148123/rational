package com.hzs.rc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hzs.rc.entity.UserDetail;
import lombok.Data;

import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: 二级评论
 * @Date 2020年05月03日
 */
@Data
public class LowCommentVO {
    private Integer id;

    private Integer parentId;

    private String content;

    private Integer type;

    private LowCommentatorVO lowCommentatorVO;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer likeCount;
}
