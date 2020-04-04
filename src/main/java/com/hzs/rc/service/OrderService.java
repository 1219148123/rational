package com.hzs.rc.service;

import com.hzs.rc.dto.OrderDTO;
import com.hzs.rc.vo.OrderV0;

import java.util.List;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年03月20日
 * @version : 1.0
 */
public interface OrderService {
    void InsertOrder(OrderDTO orderDTO);

    //查询未结账的订单及详情
    List<OrderV0> getOrderV0List(Integer userId);

    List<OrderV0> getOrderV0ListPaied(Integer userId);

    void updatePayStatus(Integer orderId,Integer user,Double spent);
}
