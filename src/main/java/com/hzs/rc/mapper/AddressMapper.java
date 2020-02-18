package com.hzs.rc.mapper;

import com.hzs.rc.entity.Address;
import com.hzs.rc.vo.AddressVO;

import java.util.List;

public interface AddressMapper {
    int insert(Address record);

    List<AddressVO> getAllAddress(Integer userId);

    int deleteAddress(Integer id);

    AddressVO addressDetail(Integer id);

    int updateAddress(Address address);
}