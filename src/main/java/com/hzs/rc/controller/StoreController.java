package com.hzs.rc.controller;

import com.hzs.rc.dto.StoreDTO;
import com.hzs.rc.service.StoreService;
import com.hzs.rc.service.UserDetailService;
import com.hzs.rc.vo.StoreGoodsVO;
import com.hzs.rc.vo.StoreVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/sto")
@Api(value = "店铺模块")
public class StoreController {
    @Resource
    StoreService storeService;
    @Resource
    UserDetailService userDetailService;

    String photo = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    @ApiOperation(value = "添加店铺", notes = "根据参数添加店铺")
    @PostMapping(value = "/test")
    public String test(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "D://image//store//";
        File dest = new File(new File(filePath).getAbsolutePath() + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            LOGGER.info("{}", dest + "/////");
            file.transferTo(dest);
            photo = dest.toString();
            return "店铺图片上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "插入失败";
    }

    @ApiOperation(value = "添加店铺", notes = "根据参数添加店铺")
    @PostMapping(value = "/add")
    public void addStore(@RequestBody @Valid StoreDTO storeDTO, HttpServletRequest httpServletRequest) {
        storeService.inserStore(storeDTO, photo);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("hzsUser", userDetailService.getUserDetail(storeDTO.getOwnerId()));
    }

    @ApiOperation(value = "获取所有店铺及商品", notes = "获取所有店铺及商品")
    @GetMapping(value = "/getStoreGoodsList")
    public List<StoreGoodsVO> getStoreGoods() {
        return storeService.getStoreGoods();
    }

    @ApiOperation(value = "获取所有店铺", notes = "所有店铺")
    @GetMapping(value = "/getStoreList")
    public List<StoreVO> getStoreList(String userId) {
        return storeService.storeList(Integer.valueOf(userId));
    }

    @ApiOperation(value = "获取店铺详情", notes = "店铺详情")
    @GetMapping(value = "/getStore")
    public StoreVO getStoreDetail(String id) {
        return storeService.stogerDetail(Integer.valueOf(id));
    }

    @ApiOperation(value = "修改店铺", notes = "修改店铺")
    @PostMapping(value = "/updateStore")
    public void updateStore(@Valid StoreDTO storeDTO, @RequestParam("file") MultipartFile file) {
        storeService.updateStore(storeDTO, file);
    }

    @ApiOperation(value = "修改置为无效", notes = "修改店铺")
    @DeleteMapping(value = "/deleteStore")
    public void deleteStore(String id) {
        storeService.invalidStore(Integer.valueOf(id));
    }


}
