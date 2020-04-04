package com.hzs.rc.service;

import com.hzs.rc.dto.AddressDTO;
import com.hzs.rc.vo.AddressVO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年02月18日
 * @version : 1.0
 */
public interface AddressService {
    public int addAddress(AddressDTO addressDTO);

    public List<AddressVO> addressManager(Integer userId);

    public int deleteAddress(Integer id);

    public AddressVO addressDetail(Integer id);

    public int updateAddress(AddressDTO addressDTO);
}

