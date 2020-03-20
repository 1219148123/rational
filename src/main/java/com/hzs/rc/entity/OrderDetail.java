package com.hzs.rc.entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderDetail {
    private Integer id;

    private Integer orderId;

    private Integer goodId;

    private Integer quantity;

    private Double price;

    private BigDecimal totalPrice;
}