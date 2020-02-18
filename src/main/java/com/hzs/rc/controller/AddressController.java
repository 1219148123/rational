package com.hzs.rc.controller;

import com.hzs.rc.dto.AddressDTO;
import com.hzs.rc.service.AddressService;
import com.hzs.rc.vo.AddressVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年02月18日
 */
@RestController
@RequestMapping("/address")
@Api(value = "地址模块")
public class AddressController {
    @Resource
    AddressService addressService;

    @ApiOperation(value = "新增地址", notes = "收获人和联系电话不为空")
    @PostMapping(value = "/addAddress")
    public Integer insertAddress(@Valid @RequestBody AddressDTO addressDTO) {
        return addressService.addAddress(addressDTO);
    }

    @ApiOperation(value = "地址管理", notes = "查询所有地址信息")
    @GetMapping(value = "/addressMng")
    public List<AddressVO> addressMng() {
        return addressService.addressManager();
    }

    @ApiOperation(value = "地址删除", notes = "删除对应地址")
    @DeleteMapping(value = "/address")
    public int deleteAddress(String id) {
        return addressService.deleteAddress(Integer.valueOf(id));
    }

    @ApiOperation(value = "地址详情", notes = "查看具体的地址信息")
    @GetMapping(value = "/address")
    public AddressVO addressDeatil(String id) {
        return addressService.addressDetail(Integer.valueOf(id));
    }

    @ApiOperation(value = "地址修改", notes = "修改地址信息")
    @PostMapping(value = "/address")
    public int addressUpdate(@Valid @RequestBody AddressDTO addressDTO) {
        return addressService.updateAddress(addressDTO);
    }
}
