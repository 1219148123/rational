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

    @PostMapping("/uploads")
    public String upload(MultipartFile[] uploadFiles, HttpServletRequest request) {
        List list = new ArrayList();//存储生成的访问路径
        if (uploadFiles.length > 0) {
            for (int i = 0; i < uploadFiles.length; i++) {
                MultipartFile uploadFile = uploadFiles[i];
                //设置上传文件的位置在该项目目录下的uploadFile文件夹下，并根据上传的文件日期，进行分类保存
                File folder = new File("D://image//");
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                String oldName = uploadFile.getOriginalFilename();
                System.out.println("oldName = " + oldName);
                try {
                    //保存文件
                    uploadFile.transferTo(new File(folder, oldName));

                    //生成上传文件的访问路径
                    String filePath = "D://image//" + oldName;
                    list.add(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return list.toString();
        } else if (uploadFiles.length == 0) {
            return "请选择文件";
        }
        return "上传失败";
    }
}
