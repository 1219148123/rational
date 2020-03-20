package com.hzs.rc.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月20日
 */
@Data
public class OrderV0 {
    private Integer orderId;

    private Integer userId;

    private Date orderTime;

    private BigDecimal totalPrice;

    private Integer addressId;

    private Integer orderStatus;

    private List<OrderDetailVO> orderDetailVOList;
}
