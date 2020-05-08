package com.hzs.rc.controller.admin;

import com.hzs.rc.entity.Admin;
import com.hzs.rc.mapper.*;
import com.hzs.rc.service.*;
import com.hzs.rc.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年05月08日
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @Resource
    UserDetailMapper userDetailMapper;

    @Resource
    CommentMapper commentMapper;

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    DiscussMapper discussMapper;

    @Resource
    StoreMapper storeMapper;

    @ApiOperation(value = "管理员添加", notes = "添加管理员")
    @PostMapping("/add")
    public void insertAdmin(@Valid @RequestBody Admin admin) {
        adminService.insertAdmin(admin);
    }

    @ApiOperation(value = "管理员登录", notes = "账户密码登录")
    @PostMapping(value = "/login")
    public Object login(@Valid @RequestBody Admin admin) {
        Integer res = adminService.login(admin);
        if (res != 0 && res != -1) {
            return 1;//登录成功
        }
        return res;
    }

    @ApiOperation(value = "用户列表", notes = "用户列表")
    @PostMapping(value = "/userList")
    public List<UserDetailVO> userList() {
        List<UserDetailVO> userList = userDetailMapper.userList();
        return userList;
    }

    @ApiOperation(value = "评论列表", notes = "评论列表")
    @PostMapping(value = "/commentList")
    public List<CommentVO> commentList() {
        List<CommentVO> commentList = commentMapper.commentList();
        return commentList;
    }

    @ApiOperation(value = "评论列表", notes = "评论列表")
    @PostMapping(value = "/goodList")
    public List<GoodsVO> goodsList() {
        List<GoodsVO> goodslist = goodsMapper.goodsList();
        return goodslist;
    }

    @ApiOperation(value = "评论列表", notes = "评论列表")
    @PostMapping(value = "/discussList")
    public List<DiscussVO> disccussList() {
        List<DiscussVO> discussList = discussMapper.discussList();
        return discussList;
    }

    @ApiOperation(value = "评论列表", notes = "评论列表")
    @PostMapping(value = "/storeList")
    public List<StoreVO> storeList() {
        List<StoreVO> storeList = storeMapper.storeList();
        return storeList;
    }
}
