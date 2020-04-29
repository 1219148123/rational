package com.hzs.rc.controller;

import com.hzs.rc.dto.DiscussDTO;
import com.hzs.rc.service.DiscussService;
import com.hzs.rc.vo.DiscussVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年04月24日
 */
@RestController
@RequestMapping("/discuss")
public class DiscussController {
    @Resource
    DiscussService discussService;

    @ApiOperation(value = "发表帖子", notes = "帖子插入")
    @PostMapping("/insert")
    public void insertDiscuss(@Valid @RequestBody DiscussDTO discussDTO) {
        discussService.insert(discussDTO);
    }

    @ApiOperation(value = "查看详情", notes = "帖子详情")
    @GetMapping("/select")
    public DiscussVO selectDiscuss(Integer id) {
        return discussService.selectDiscuss(id);
    }

    @ApiOperation(value = "修改", notes = "帖子修改")
    @PostMapping("/update")
    public void updateDiscuss(@Valid @RequestBody DiscussDTO discussDTO) {
        discussService.update(discussDTO);
    }
}
