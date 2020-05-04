package com.hzs.rc.controller;

import com.hzs.rc.dto.GoodsDTO;
import com.hzs.rc.entity.FileUploadResult;
import com.hzs.rc.service.GoodService;
import com.hzs.rc.service.impl.FileUploadService;
import com.hzs.rc.vo.GoodsVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月18日
 */
@RestController
@RequestMapping("good")
public class GoodController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodController.class);
    String photo = "";
    @Resource
    GoodService goodService;
    @Autowired
    private FileUploadService fileUploadService;
    @ApiOperation(value = "商品插入", notes = "商品插入")
    @PostMapping("/insert")
    public void insertGood(MultipartFile[] uploadFiles, @Valid GoodsDTO goodsDTO) {
        goodService.insertGood(goodsDTO, uploadFiles);
    }

    @ApiOperation(value = "商品上传图片", notes = "商品上传图片")
    @PostMapping(value = "/test")
    public FileUploadResult test(@RequestParam("file") MultipartFile uploadFile) {
        FileUploadResult upload = this.fileUploadService.upload(uploadFile);
        this.photo = this.photo + upload.getName()+",";
        return upload;
    }

    @ApiOperation(value = "商品插入", notes = "商品插入")
    @PostMapping("/add")
    public void addGood(@RequestBody @Valid  GoodsDTO goodsDTO) {
        goodService.addGood(goodsDTO,photo);
        this.photo = "";
    }

    @ApiOperation(value = "商品删除", notes = "置为无效")
    @DeleteMapping("/delete")
    public void delete(String goodId) {
        goodService.invalidGood(Integer.valueOf(goodId));
    }

    @ApiOperation(value = "商品详情", notes = "商品详情")
    @GetMapping("/get")
    public GoodsVO getDetail(String goodId) {
        return goodService.goodDetail(Integer.valueOf(goodId));
    }

    @ApiOperation(value = "商品查看", notes = "某个店铺所有的商品查看")
    @GetMapping("getList")
    public List<GoodsVO> getList(String storeId) {
        return goodService.goodsList(Integer.valueOf(storeId));
    }

    @ApiOperation(value = "商品修改", notes = "商品修改")
    @PostMapping("update")
    public void updateGood(MultipartFile[] uploadFiles, @Valid GoodsDTO goodsDTO) {
        goodService.updateGood(goodsDTO, uploadFiles);
    }
}
