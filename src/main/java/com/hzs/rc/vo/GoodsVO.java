package com.hzs.rc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月18日
 */
@Data
public class GoodsVO {
    private Integer goodId;

    private Integer storeId;

    private String goodName;

    private Float price;

    private Integer num;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    private Integer category;

    private String imgAddr;

    private String description;

    private Integer priority;

    private Integer goodStatus;

    //加入购物车的数量
    private Integer quantity;

}
