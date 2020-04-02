package com.hzs.rc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月17日
 */
@Data
public class StoreVO {
    private Integer storeId;

    private Integer ownerId;

    private String storeName;

    private String storePhoto;

    private String storeDesc;

    private Integer storeCate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private String stateCode;
}
