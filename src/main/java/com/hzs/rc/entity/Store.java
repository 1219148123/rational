package com.hzs.rc.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Store {
    private Integer storeId;

    private Integer ownerId;

    private String storeName;

    private String storeDesc;

    private Integer storeCate;

    private Date createTime;

    private String stateCode;
}