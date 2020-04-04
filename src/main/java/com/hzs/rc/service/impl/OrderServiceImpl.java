package com.hzs.rc.service.impl;

import com.hzs.rc.dto.OrderDTO;
import com.hzs.rc.entity.Order;
import com.hzs.rc.entity.OrderDetail;
import com.hzs.rc.mapper.CartMapper;
import com.hzs.rc.mapper.OrderDetailMapper;
import com.hzs.rc.mapper.OrderMapper;
import com.hzs.rc.mapper.UserDetailMapper;
import com.hzs.rc.service.OrderService;
import com.hzs.rc.vo.CartVO;
import com.hzs.rc.vo.GoodsVO;
import com.hzs.rc.vo.OrderV0;
import com.hzs.rc.vo.StoreGoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月20日
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Resource
    CartMapper cartMapper;
    @Resource
    UserDetailMapper userDetailMapper;
    @Resource
    OrderDetailMapper orderDetailMapper;

    @Override
    @Transactional
    public void InsertOrder(OrderDTO orderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        //设置下单时间、下单总价
        List<StoreGoodsVO> storeGoodsVOS = cartMapper.cartSpecialList(order.getUserId());
        BigDecimal totalPrice = new BigDecimal("0.00");
        //计算总价
        for (int i = 0; i < storeGoodsVOS.size(); i++) {
            List<GoodsVO> storeGoods = storeGoodsVOS.get(i).getStoreGoods();
            for (int j = 0; j < storeGoods.size(); j++) {
                GoodsVO goodsVO = storeGoods.get(j);
                totalPrice = totalPrice.add(BigDecimal.valueOf(goodsVO.getPrice() * goodsVO.getQuantity()));
            }
        }
        order.setTotalPrice(totalPrice);
        order.setOrderTime(new Date());
        orderMapper.insertOrder(order);
        //插入详情

        for (int i = 0; i < storeGoodsVOS.size(); i++) {
            List<GoodsVO> storeGoods = storeGoodsVOS.get(i).getStoreGoods();
            for (int j = 0; j < storeGoods.size(); j++) {
                GoodsVO goodsVO = storeGoods.get(j);
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(order.getOrderId());
                orderDetail.setGoodId(goodsVO.getGoodId());
                orderDetail.setPrice(Double.valueOf(goodsVO.getPrice()));
                orderDetail.setQuantity(goodsVO.getQuantity());
                orderDetail.setTotalPrice(BigDecimal.valueOf(goodsVO.getPrice() * goodsVO.getQuantity()));
                orderDetailMapper.insertOrdertail(orderDetail);
            }
        }
        //从购物车中删除选择的商品
        List<CartVO> allCheckedCartGood = cartMapper.getAllCheckedCartGood(order.getUserId());
        for (int i = 0; i < allCheckedCartGood.size(); i++) {
            cartMapper.deleteCartGood(allCheckedCartGood.get(i).getId());
        }
    }

    @Override
    public List<OrderV0> getOrderV0List(Integer userId) {
        return orderMapper.getOrderV0List(userId);
    }

    @Override
    public List<OrderV0> getOrderV0ListPaied(Integer userId) {
        return orderMapper.getOrderV0ListPaied(userId);
    }

    @Transactional
    @Override
    public void updatePayStatus(Integer orderId, Integer userId, Double spent) {
        //修改消费数额
        userDetailMapper.updateCurSpent(userId,spent);
        //订单状态修改
        orderMapper.updatePayStatus(orderId);
    }
}
