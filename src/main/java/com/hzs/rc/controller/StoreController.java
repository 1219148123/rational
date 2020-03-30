package com.hzs.rc.controller;

import com.hzs.rc.dto.StoreDTO;
import com.hzs.rc.service.StoreService;
import com.hzs.rc.vo.StoreGoodsVO;
import com.hzs.rc.vo.StoreVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;


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
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    @ApiOperation(value = "添加店铺", notes = "根据参数添加店铺")
    @PostMapping(value = "/addStore")
    public void addStore(@Valid StoreDTO storeDTO, @RequestParam("file") MultipartFile file) {
        LOGGER.info("{}", storeDTO + "-------------" + file.getOriginalFilename());
        storeService.inserStore(storeDTO,file);
    }

    @ApiOperation(value = "获取所有店铺及商品", notes = "获取所有店铺及商品")
    @GetMapping(value = "/getStoreGoodsList")
    public List<StoreGoodsVO> getStoreGoods() {
        return storeService.getStoreGoods();
    }
    @ApiOperation(value = "获取所有店铺", notes = "所有店铺")
    @GetMapping(value = "/getStoreList")
    public List<StoreVO> getStoreList(String userId){
        return storeService.storeList(Integer.valueOf(userId));
    }

    @ApiOperation(value = "获取店铺详情", notes = "店铺详情")
    @GetMapping(value = "/getStore")
    public StoreVO getStoreDetail(String id){
        return storeService.stogerDetail(Integer.valueOf(id));
    }

    @ApiOperation(value = "修改店铺", notes = "修改店铺")
    @PostMapping(value = "/updateStore")
    public void updateStore(@Valid StoreDTO storeDTO, @RequestParam("file") MultipartFile file){
        storeService.updateStore(storeDTO,file);
    }

    @ApiOperation(value = "修改置为无效", notes = "修改店铺")
    @DeleteMapping(value = "/deleteStore")
    public void deleteStore(String id){
        storeService.invalidStore(Integer.valueOf(id));
    }
}
