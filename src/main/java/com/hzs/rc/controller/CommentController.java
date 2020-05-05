package com.hzs.rc.controller;

import com.hzs.rc.dto.CommentDTO;
import com.hzs.rc.service.CommentService;
import com.hzs.rc.vo.CommentVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年05月03日
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    CommentService commentService;

    @ApiOperation(value = "发表评论", notes = "评论插入")
    @PostMapping("/insert")
    public void insertDiscuss(@Valid @RequestBody CommentDTO commentDTO) {
        commentService.insert(commentDTO);
    }

    @ApiOperation(value = "评论列表查询", notes = "评论列表")
    @GetMapping("/list")
    public List<CommentVO> commentMng(String id) {
        return commentService.commentMng(Integer.valueOf(id));
    }

    @ApiOperation(value = "点赞", notes = "点赞")
    @PostMapping("/likeCount")
    public void addLike(String id) {
        commentService.updateLikeCount(Integer.valueOf(id));
    }
}
