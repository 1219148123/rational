package com.hzs.rc.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Order {
    private Integer orderId;

    private Integer userId;

    private Date orderTime;

    private BigDecimal totalPrice;

    private Integer addressId;

    private Integer orderStatus;
}