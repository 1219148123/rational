package com.hzs.rc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hzs.rc.entity.Comment;
import com.hzs.rc.entity.UserDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年05月02日
 */
@Data
public class CommentVO {
    private Integer id;

    private Integer parentId;

    private String content;

    private Integer type;

    private CommentatorVO commentatorVO;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer likeCount;

    private List<LowCommentVO> lowCommentVOList;
}
