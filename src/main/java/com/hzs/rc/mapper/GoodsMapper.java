package com.hzs.rc.mapper;

import com.hzs.rc.entity.Goods;
import com.hzs.rc.vo.GoodsVO;

import java.util.List;

public interface GoodsMapper {
    //店主新增商品 默认为上架
    int insertGood(Goods record);

    //新增和修改的时候修改图片地址
    void updateImgAddr(Goods goods);

    //店主查看自己店铺的商品
    List<GoodsVO> selectGoodsList(Integer storeId);

    //店主查看自己店铺的商品
    List<GoodsVO> selectInvalidGoodsList(Integer storeId);

    //商品下架
    void invalidGood(Integer goodId);

    //商品上架
    void validGood(Integer goodId);

    //商品信息修改
    void updateGoodsDetail(Goods goods);

    //商品信息查看
    GoodsVO goodsDetail(Integer goodId);

    List<GoodsVO> goodsList();

    //获取商品列表 通过价格升序 查8个
    List<GoodsVO> seleteGoodsByPrice();

    //获取商品列表 通过权重降序 查6个
    List<GoodsVO> seleteGoodsByPro();
}