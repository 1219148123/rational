package com.hzs.rc.controller;

import com.hzs.rc.dto.StoreDTO;
import com.hzs.rc.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月10日
 */
@RestController
@RequestMapping("/store")
@Api(value = "店铺模块")
public class StoreController {
    @Resource
    StoreService storeService;


    @ApiOperation(value = "添加店铺", notes = "根据参数添加店铺")
    @PostMapping(value = "/addStore")
    public void addStore(@Valid @RequestBody StoreDTO storeDTO) {
         storeService.inserStore(storeDTO);
    }

}
