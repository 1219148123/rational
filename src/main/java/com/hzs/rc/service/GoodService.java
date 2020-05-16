package com.hzs.rc.service;

import com.hzs.rc.dto.GoodsDTO;
import com.hzs.rc.vo.GoodsVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年03月18日
 * @version : 1.0
 */
public interface GoodService {
    void insertGood(GoodsDTO goodsDTO, MultipartFile[] uploadFiles);

    void addGood(GoodsDTO goodsDTO,String photo);

    void invalidGood(Integer goodId);

    void validGood(Integer goodId);

    List<GoodsVO> goodsList(Integer storeId);

    List<GoodsVO> selectInvalidGoodsList(Integer storeId);

    GoodsVO goodDetail(Integer goodId);

    void updateGood(GoodsDTO goodsDTO,String photo);

    List<GoodsVO> seleteGoodsByPrice();

    //获取商品列表 通过权重降序 查6个
    List<GoodsVO> seleteGoodsByPro();
}
