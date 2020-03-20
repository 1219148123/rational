package com.hzs.rc.mapper;

import com.hzs.rc.entity.Order;
import com.hzs.rc.vo.OrderV0;

import java.util.List;

public interface OrderMapper {
    //订单生成
    int insertOrder(Order record);

    //查询未结账的订单及详情
    List<OrderV0> getOrderV0List(Integer userId);
    //查询已经结账的订单及详情
}