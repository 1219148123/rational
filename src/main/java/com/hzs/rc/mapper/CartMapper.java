package com.hzs.rc.mapper;

import com.hzs.rc.entity.Cart;
import com.hzs.rc.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    //商品添加到购物车 需要三个主要属性  哪个用户 哪个商品  商品数量
    int insertCart(Cart record);

    //2.购物车商品的删除
    void deleteCartGood(Integer id);

    //3.清空购物车
    void flushCart(Integer userId);

    //4.购物车内商品选择
    void checkGood(Integer id);

    //5.购物车商品全选
    void checkAll(Integer userId);

    //6.购物车商品全不选
    void inCheckAll(Integer userId);

    //7.购物车内商品数量修改
    void changeNum(@Param(value = "id")Integer id,@Param(value = "num")Integer num);

    //8.获取某用户所有的有效的商品
    List<CartVO> getAllCartGood(Integer userId);

    //9.获取用户所有有效且已选的购物车内的商品 下单时候使用该数据
    List<CartVO> getAllCheckedCartGood(Integer userId);

    //10.获取已经失效的商品
    List<CartVO> getAllCartInvalidGood(Integer userId);
}