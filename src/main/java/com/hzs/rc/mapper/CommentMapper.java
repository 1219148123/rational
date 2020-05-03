package com.hzs.rc.mapper;

import com.hzs.rc.entity.Comment;
import com.hzs.rc.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    //1.发表评论
    int insert(Comment record);

    //2.删除评论
    void delete(Integer id);

    //3.分页查询帖子相关评论及评论的评论同时查出评论人信息
    List<CommentVO> commentMng();

    //4.评论点赞数+1
    void updateLikeCount(Integer id);
}