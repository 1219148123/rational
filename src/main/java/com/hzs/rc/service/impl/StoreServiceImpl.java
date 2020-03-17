package com.hzs.rc.service.impl;

import com.hzs.rc.dto.StoreDTO;
import com.hzs.rc.entity.Store;
import com.hzs.rc.mapper.StoreMapper;
import com.hzs.rc.service.StoreService;
import com.hzs.rc.vo.StoreVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    StoreMapper storeMapper;
    @Override
    public void inserStore(StoreDTO storeDTO,String storePhoto) {
        //1.创建Store对象
        Store store = new Store();
        //2.bean属性转移
        BeanUtils.copyProperties(storeDTO,store);
        store.setCreateTime(new Date());
        store.setOwnerId(1);//TODO 后期改成当前登录用户的id
        store.setStateCode("1001");
        store.setStorePhoto(storePhoto);
        //3.插入店铺
        storeMapper.insertStore(store);
    }

    @Override
    public List<StoreVO> storeList(Integer userId) {
        return storeMapper.storeListUser(userId);
    }

    @Override
    public void updateStore(StoreDTO storeDTO, String storePhoto) {
        Store store = new Store();
        BeanUtils.copyProperties(storeDTO,store);
        store.setStorePhoto(storePhoto);
        storeMapper.updateStore(store);
    }

    @Override
    public void invalidStore(Integer id) {
        storeMapper.invalidStore(id);
    }

    @Override
    public StoreVO stogerDetail(Integer id) {
        return storeMapper.storeDetail(id);
    }
}
