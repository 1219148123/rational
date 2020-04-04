package com.hzs.rc.service.impl;

import com.hzs.rc.controller.StoreController;
import com.hzs.rc.dto.StoreDTO;
import com.hzs.rc.entity.Store;
import com.hzs.rc.mapper.StoreMapper;
import com.hzs.rc.mapper.UserDetailMapper;
import com.hzs.rc.service.StoreService;
import com.hzs.rc.vo.StoreGoodsVO;
import com.hzs.rc.vo.StoreVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月10日
 */
@Service
public class StoreServiceImpl implements StoreService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreServiceImpl.class);
    @Resource
    StoreMapper storeMapper;
    @Resource
    UserDetailMapper userDetailMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inserStore(StoreDTO storeDTO, String photo) {
        //1.创建Store对象
        Store store = new Store();
        //2.bean属性转移
        BeanUtils.copyProperties(storeDTO, store);
        store.setCreateTime(new Date());
        store.setStateCode("1001");
        //3.插入店铺
        storeMapper.insertStore(store);
        store.setStorePhoto(photo);
        storeMapper.updatePhoto(store);
        //4.用户开店转态置为1
        userDetailMapper.openStore(storeDTO.getOwnerId());
    }

    @Override
    public List<StoreVO> storeList(Integer userId) {
        return storeMapper.storeListUser(userId);
    }

    @Override
    public void updateStore(StoreDTO storeDTO, MultipartFile file) {
        Store store = new Store();
        BeanUtils.copyProperties(storeDTO, store);
        storeMapper.updateStore(store);
        System.out.println(store);
        String storePhoto = upload(file, store.getStoreId());
        store.setStorePhoto(storePhoto);
        storeMapper.updatePhoto(store);
    }

    @Override
    public void invalidStore(Integer id) {
        storeMapper.invalidStore(id);
    }

    @Override
    public StoreVO stogerDetail(Integer id) {
        return storeMapper.storeDetail(id);
    }

    @Override
    public List<StoreGoodsVO> getStoreGoods() {
        List<StoreGoodsVO> storeGoods = storeMapper.getStoreGoods();
        return storeGoods;
    }

    @Transactional(rollbackFor = Exception.class)
    public String upload(MultipartFile file, Integer storeId) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "D://image//store//" + storeId + "//";
        File dest = new File(new File(filePath).getAbsolutePath() + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            LOGGER.info("{}", dest + "/////");
            file.transferTo(dest);
            return dest.toString();
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "插入失败";
    }
}
