package com.hzs.rc.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Store {
    private Integer storeId;

    private Integer ownerId;

    private String storeName;

    private String storePhoto;

    private String storeDesc;

    private Integer storeCate;

    private Date createTime;

    private String stateCode;
}