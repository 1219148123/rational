package com.hzs.rc.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月19日
 */
@Data
public class CartVO {
    private Integer id;

    private Integer userId;

    private Integer goodId;

    private Integer quantity;

    private Integer checked;

    private Date createTime;

    private Date updateTime;

    private GoodsVO goodsVO;
}
