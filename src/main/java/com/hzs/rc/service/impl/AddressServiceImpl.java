package com.hzs.rc.service.impl;

import com.hzs.rc.dto.AddressDTO;
import com.hzs.rc.entity.Address;
import com.hzs.rc.mapper.AddressMapper;
import com.hzs.rc.service.AddressService;
import com.hzs.rc.vo.AddressVO;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年02月18日
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper addressMapper;
    /**
     *@描述
     *@参数  [addressDTO]
     *@返回值  int
     *@创建人  hanzs
     *@创建时间  2020/2/18
     */
    @Override
    public int addAddress(AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO,address);
        address.setUserId(1);//ToDo
        int insert = addressMapper.insert(address);
        return insert;
    }

    /**
     *@描述
     *@参数  []
     *@返回值  java.util.List<com.hzs.rc.vo.AddressVO>
     *@创建人  hanzs
     *@创建时间  2020/2/18
     */
    @Override
    public List<AddressVO> addressManager(Integer userId) {
       //Todo 获取当前登录用户userId
        List<AddressVO> allAddress = addressMapper.getAllAddress(userId);
        return allAddress;
    }

    /**
     *@描述
     *@参数  [id]
     *@返回值  int
     *@创建人  hanzs
     *@创建时间  2020/2/18
     */
    @Override
    public int deleteAddress(Integer id) {
        return addressMapper.deleteAddress(id);
    }

    /**
     *@描述
     *@参数  [id]
     *@返回值  com.hzs.rc.vo.AddressVO
     *@创建人  hanzs
     *@创建时间  2020/2/18
     */
    @Override
    public AddressVO addressDetail(Integer id) {
        return addressMapper.addressDetail(id);
    }

    /**
     *@描述
     *@参数  [addressDTO]
     *@返回值  int
     *@创建人  hanzs
     *@创建时间  2020/2/18
     */
    @Override
    public int updateAddress(AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO,address);
        return addressMapper.updateAddress(address);
    }
}
