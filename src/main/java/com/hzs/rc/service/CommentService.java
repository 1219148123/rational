package com.hzs.rc.service;

import com.hzs.rc.dto.CommentDTO;
import com.hzs.rc.entity.Comment;
import com.hzs.rc.vo.CommentVO;

import java.util.List;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年05月03日
 * @version : 1.0
 */
public interface CommentService {
    int insert(CommentDTO commentDTO);

    List<CommentVO> commentMng();

    void updateLikeCount(Integer id);
}
