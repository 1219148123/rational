package com.hzs.rc.controller;

import com.hzs.rc.dto.GoodsDTO;
import com.hzs.rc.service.GoodService;
import com.hzs.rc.vo.GoodsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Resource
    GoodService goodService;

    @PostMapping("/insert")
    public void insertGood(MultipartFile[] uploadFiles, @Valid GoodsDTO goodsDTO) {
        goodService.insertGood(goodsDTO, uploadFiles);
    }

    @DeleteMapping("/delete")
    public void delete(String goodId) {
        goodService.invalidGood(Integer.valueOf(goodId));
    }

    @GetMapping("/get")
    public GoodsVO getDetail(String goodId) {
        return goodService.goodDetail(Integer.valueOf(goodId));
    }

    @GetMapping("getList")
    public List<GoodsVO> getList(String storeId){
        return goodService.goodsList(Integer.valueOf(storeId));
    }

    @PostMapping("update")
    public void updateGood(MultipartFile[] uploadFiles, @Valid GoodsDTO goodsDTO){
        goodService.updateGood(goodsDTO,uploadFiles);
    }
}
