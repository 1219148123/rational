package com.hzs.rc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderTime;

    private BigDecimal totalPrice;

    private Integer addressId;

    private Integer orderStatus;

    private List<OrderDetailVO> orderDetailVOList;
}
