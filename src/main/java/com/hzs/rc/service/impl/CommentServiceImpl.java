package com.hzs.rc.service.impl;

import com.hzs.rc.dto.CommentDTO;
import com.hzs.rc.entity.Comment;
import com.hzs.rc.mapper.CommentMapper;
import com.hzs.rc.service.CommentService;
import com.hzs.rc.vo.CommentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年05月03日
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper commentMapper;
    @Override
    public int insert(CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
        comment.setCreateTime(new Date());
        return commentMapper.insert(comment);
    }

    @Override
    public List<CommentVO> commentMng() {
        return commentMapper.commentMng();
    }

    @Override
    public void updateLikeCount(Integer id) {
        commentMapper.updateLikeCount(id);
    }
}
