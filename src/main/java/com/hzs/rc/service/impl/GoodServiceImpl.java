package com.hzs.rc.service.impl;

import com.hzs.rc.dto.GoodsDTO;
import com.hzs.rc.entity.Goods;
import com.hzs.rc.mapper.GoodsMapper;
import com.hzs.rc.service.GoodService;
import com.hzs.rc.vo.GoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月18日
 */
@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public void insertGood(GoodsDTO goodsDTO, MultipartFile[] uploadFiles) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO, goods);
        goods.setUpdateTime(new Date());
        goodsMapper.insertGood(goods);
        List upload = upload(uploadFiles, goods.getStoreId());
        String imgAddr = "";
        for (int i = 0; i < upload.size() - 1; i++) {
            imgAddr += upload.get(i) + ",";
        }
        imgAddr += upload.get(upload.size() - 1);
        goods.setImgAddr(imgAddr);
        goodsMapper.updateImgAddr(goods);
    }

    @Override
    public void addGood(GoodsDTO goodsDTO,String photo) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO, goods);
        goods.setUpdateTime(new Date());
        goodsMapper.insertGood(goods);
        goods.setImgAddr(photo);
        goodsMapper.updateImgAddr(goods);
    }

    @Override
    public void invalidGood(Integer goodId) {
        goodsMapper.invalidGood(goodId);
    }

    @Override
    public List<GoodsVO> goodsList(Integer storeId) {
        return goodsMapper.selectGoodsList(storeId);
    }

    @Override
    public GoodsVO goodDetail(Integer goodId) {
        return goodsMapper.goodsDetail(goodId);
    }

    @Override
    public void updateGood(GoodsDTO goodsDTO, MultipartFile[] uploadFiles) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO, goods);
        goods.setUpdateTime(new Date());
        goodsMapper.updateGoodsDetail(goods);
        //获取当前这个商品的信息
        GoodsVO goodsVO = goodsMapper.goodsDetail(goods.getGoodId());
        //修改
        BeanUtils.copyProperties(goodsVO, goods);
        List upload = upload(uploadFiles, goods.getStoreId());
        String imgAddr = "";
        for (int i = 0; i < upload.size() - 1; i++) {
            imgAddr += upload.get(i) + ",";
        }
        imgAddr += upload.get(upload.size() - 1);
        goods.setImgAddr(imgAddr);
        goodsMapper.updateImgAddr(goods);
    }


    public List upload(MultipartFile[] uploadFiles, int storeId) {
        List list = new ArrayList();//存储生成的访问路径
        if (uploadFiles.length > 0) {
            for (int i = 0; i < uploadFiles.length; i++) {
                MultipartFile uploadFile = uploadFiles[i];
                String fileName = uploadFile.getOriginalFilename();
                String filePath = "D://image//store//" + storeId + "//goods//";
                File dest = new File(new File(filePath).getAbsolutePath() + "/" + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    //保存文件
                    uploadFile.transferTo(dest);
                    //生成上传文件的访问路径
                    list.add(filePath + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return list;
        } else if (uploadFiles.length == 0) {
            return null;
        }
        return null;
    }
}
