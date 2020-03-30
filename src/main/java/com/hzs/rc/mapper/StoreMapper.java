package com.hzs.rc.mapper;

import com.hzs.rc.entity.Store;
import com.hzs.rc.vo.StoreGoodsVO;
import com.hzs.rc.vo.StoreVO;

import java.util.List;

public interface StoreMapper {
    //开店 普通用户
    void insertStore(Store record);

    //开店 和修改的时候修改图片
    void updatePhoto(Store store);

    //查看所有的店铺  普通用户 目前查的是所有状态后续改为只查有效的店铺 TODO
    List<StoreVO> storeListUser(Integer userId);

    //查看某个店铺用于修改前的信息查看回显 普通用户
    StoreVO storeDetail(Integer id);

    //查看所有的店铺及该店铺下商品 用户
    List<StoreGoodsVO> getStoreGoods();

    //更新店铺信息 普通用户
    void updateStore(Store store);

    //店铺转态设置为无效 1001  管理员  店铺删除 状态置为无效 1001 普通用户
    void invalidStore(Integer id);

    //店铺状态设置为有效 1000  管理员
    void validStore(Integer id);

    //查看所有的店铺信息 管理员
    List<StoreVO> storeListAdmin(Integer userId);
}