package com.hzs.rc.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月20日
 */
@Data
public class OrderDetailVO {
    private Integer id;

    private Integer orderId;

    private Integer goodId;

    private Integer quantity;

    private Double price;

    private BigDecimal totalPrice;

    private GoodsVO goodsVO;
}
