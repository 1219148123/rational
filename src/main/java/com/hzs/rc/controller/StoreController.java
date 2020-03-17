package com.hzs.rc.controller;

import com.hzs.rc.dto.StoreDTO;
import com.hzs.rc.service.StoreService;
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
        String upload = upload(file);
        LOGGER.info("{}", upload);
        storeService.inserStore(storeDTO,upload);
    }


    @ApiOperation(value = "获取店铺详情", notes = "店铺详情")
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
        String storePhoto = upload(file);
        storeService.updateStore(storeDTO,storePhoto);
    }

    @ApiOperation(value = "修改置为无效", notes = "修改店铺")
    @DeleteMapping(value = "/deleteStore")
    public void deleteStore(String id){
        storeService.invalidStore(Integer.valueOf(id));
    }

    /**
     * @描述 文件上传公共方法
     * @参数 [file]
     * @返回值 java.lang.String
     * @创建人 hanzs
     * @创建时间 2020/3/16
     */
    public String upload(MultipartFile file) {

        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "D://image//store//";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
//            LOGGER.info("{}",dest+"/////" + contentType);
            return dest.toString();
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }


}
