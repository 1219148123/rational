package com.hzs.rc.controller.admin;

import com.hzs.rc.entity.Admin;
import com.hzs.rc.mapper.*;
import com.hzs.rc.service.*;
import com.hzs.rc.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    GoodService goodService;
    @Resource
    UserDetailMapper userDetailMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    CommentMapper commentMapper;

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    DiscussMapper discussMapper;

    @Resource
    StoreMapper storeMapper;
    @Resource
    StoreService storeService;

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
    public List<AdminUser> userList() {
        List<AdminUser> userList = userDetailMapper.userList();
        return userList;
    }

    @ApiOperation(value = "评论列表", notes = "评论列表")
    @PostMapping(value = "/commentList")
    public List<CommentVO> commentList() {
        List<CommentVO> commentList = commentMapper.commentList();
        return commentList;
    }

    @ApiOperation(value = "商品列表", notes = "商品列表")
    @PostMapping(value = "/goodList")
    public List<GoodsVO> goodsList() {
        List<GoodsVO> goodslist = goodsMapper.goodsList();
        return goodslist;
    }

    @ApiOperation(value = "文章列表", notes = "文章列表")
    @PostMapping(value = "/discussList")
    public List<DiscussVO> discussList() {
        List<DiscussVO> discussList = discussMapper.discussList();
        return discussList;
    }

    @ApiOperation(value = "店铺列表", notes = "评论列表")
    @PostMapping(value = "/storeList")
    public List<StoreVO> storeList() {
        List<StoreVO> storeList = storeMapper.storeList();
        return storeList;
    }

    //店铺下架
    @ApiOperation(value = "店铺置为无效", notes = "置为无效")
    @DeleteMapping(value = "/deleteStore")
    public void deleteStore(String id) {
        storeService.invalidStore(Integer.valueOf(id));
    }

    //同意店铺上架validStore
    @ApiOperation(value = "店铺上架", notes = "置为有效")
    @PostMapping(value = "/validStore")
    public void validStore(String id) {
        storeMapper.validStore(Integer.valueOf(id));
    }
    //用户注销
    @ApiOperation(value = "用户置为无效", notes = "置为无效")
    @DeleteMapping(value = "/userDelete")
    public void deleteUser(String userId) {
        userMapper.invalidUser(Integer.valueOf(userId));
    }

    //用户激活
    @ApiOperation(value = "用户激活", notes = "置为有效")
    @PostMapping(value = "/userActive")
    public void activeUser(String userId) {
        userMapper.activeUser(Integer.valueOf(userId));
    }

    //商品下架
    @ApiOperation(value = "商品删除", notes = "置为无效")
    @DeleteMapping("/deleteGood")
    public void deleteGood(String goodId) {
        goodService.invalidGood(Integer.valueOf(goodId));
    }
    //评论删除
    @ApiOperation(value = "删除评论", notes = "直接物理删除")
    @DeleteMapping("/deleteComment")
    public void deleteComment(String id) {
        commentMapper.delete(Integer.valueOf(id));
    }
    //文章删除
    @ApiOperation(value = "删除文章", notes = "直接物理删除")
    @DeleteMapping("/deleteDiscuss")
    public void deleteDiscuss(String id) {
        discussMapper.delete(Integer.valueOf(id));
    }
}
