package com.hzs.rc.controller;

import com.hzs.rc.dto.CartDTO;
import com.hzs.rc.service.CartService;
import com.hzs.rc.vo.CartVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月19日
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    CartService cartService;
    @ApiOperation(value = "商品添加到购物车", notes = "商品添加到购物车")
    @PostMapping("insert")
    public void insetCart(@Valid @RequestBody CartDTO cartDTO) {
        cartService.insertCart(cartDTO);
    }
    @ApiOperation(value = "获取所有购物车内的商品", notes = "获取所有购物车内的商品")
    @GetMapping("/getAllCartGood")
    public List<CartVO> getAllCartGood(String userId){
       return cartService.getAllCartGood(Integer.valueOf(userId));
    }
    @ApiOperation(value = "获取购物车内的失效商品", notes = "获取购物车内的失效商品")
    @GetMapping("/getAllCartInvalidGood")
    public List<CartVO> getAllCartInvalidGood(String userId){
        return cartService.getAllCartInvalidGood(Integer.valueOf(userId));
    }

    @ApiOperation(value = "获取购物车内的已选的有效商品", notes = "添加到订单表中商品就是这些")
    @GetMapping("/getAllCheckedCartGood")
    public List<CartVO> getAllCheckedCartGood(String userId){
        return cartService.getAllCheckedCartGood(Integer.valueOf(userId));
    }

    @ApiOperation(value = "选择商品", notes = "选择的商品进行最后的下单")
    @PostMapping("/checkGood")
    public  void checkGood(String id) {
        cartService.checkGood(Integer.valueOf(id));
    }

    @ApiOperation(value = "商品全选", notes = "选择的商品进行最后的下单")
    @PostMapping("/checkAll")
    public  void checkAll(String userId) {
        cartService.checkAll(Integer.valueOf(userId));
    }

    @ApiOperation(value = "商品全不选", notes = "选择的商品进行最后的下单")
    @PostMapping("/inCheckAll")
    public  void inCheckAll(String userId) {
        cartService.inCheckAll(Integer.valueOf(userId));
    }

    @ApiOperation(value = "商品数量修改", notes = "修改商品数量但是别小于1")
    @PostMapping("/changeNum")
    public  void changeNum(String id,String num) {
        cartService.changeNum(Integer.valueOf(id),Integer.valueOf(num));
    }

    @ApiOperation(value = "商品删除", notes = "商品删除")
    @DeleteMapping("/deleteCartGood")
    public  void deleteCartGood(String id) {
        cartService.deleteCartGood(Integer.valueOf(id));
    }

    @ApiOperation(value = "清空购物车", notes = "清空购物车")
    @DeleteMapping("/flushCart")
    public  void flushCart(String userId) {
        cartService.flushCart(Integer.valueOf(userId));
    }
}
