package com.hzs.rc.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月20日
 */
@Data
public class StoreGoodsVO {
    private Integer storeId;

    private Integer ownerId;

    private String storeName;

    private String storePhoto;

    private String storeDesc;

    private Integer storeCate;

    private Date createTime;

    private String stateCode;



    private List<GoodsVO> storeGoods;


}
