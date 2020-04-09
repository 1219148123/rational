package com.hzs.rc.service.impl;

import com.hzs.rc.dto.CartDTO;
import com.hzs.rc.entity.Cart;
import com.hzs.rc.mapper.CartMapper;
import com.hzs.rc.service.CartService;
import com.hzs.rc.vo.CartVO;
import com.hzs.rc.vo.StoreGoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月19日
 */
@Service
public class CartServiceImpl implements CartService {
    @Resource
    CartMapper cartMapper;

    @Override
    public void insertCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDTO, cart);
        CartVO cartVo = cartMapper.getCartVo(cart.getGoodId(),cart.getUserId());
        if (cartVo == null) {
            cart.setCreateTime(new Date());
            cartMapper.insertCart(cart);
        } else {
            cartMapper.changeNum(cartVo.getId(), cartVo.getQuantity() + cart.getQuantity());
        }

    }

    @Override
    public List<CartVO> getAllCartGood(Integer userId) {
        return cartMapper.getAllCartGood(userId);
    }

    @Override
    public List<CartVO> getAllCheckedCartGood(Integer userId) {
        return cartMapper.getAllCheckedCartGood(userId);
    }

    @Override
    public List<StoreGoodsVO> getAllCartInvalidGood(Integer userId) {
        return cartMapper.getAllCartInvalidGood(userId);
    }

    @Override
    public List<StoreGoodsVO> cartSpecialList(Integer userId) {
        return cartMapper.cartSpecialList(userId);
    }

    @Override
    public void checkGood(Integer id) {
        cartMapper.checkGood(id);
    }

    @Override
    public void inCheckGood(Integer id) {
        cartMapper.inCheckGood(id);
    }

    @Override
    public void checkAll(Integer userId) {
        cartMapper.checkAll(userId);
    }

    @Override
    public void inCheckAll(Integer userId) {
        cartMapper.inCheckAll(userId);
    }

    @Override
    public void changeNum(Integer id, Integer num) {
        cartMapper.changeNum(id, num);
    }

    @Override
    public void deleteCartGood(Integer id) {
        cartMapper.deleteCartGood(id);
    }

    @Override
    public void flushCart(Integer userId) {
        cartMapper.flushCart(userId);
    }
}
