package com.hzs.rc.service;

import com.hzs.rc.dto.StoreDTO;
import com.hzs.rc.vo.StoreGoodsVO;
import com.hzs.rc.vo.StoreVO;
import io.swagger.models.auth.In;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年03月10日
 * @version : 1.0
 */
public interface StoreService {
    public void inserStore(StoreDTO storeDTO, String photo);

    public List<StoreVO> storeList(Integer userId);

    public void updateStore(StoreDTO storeDTO, String photo);

    public void invalidStore(Integer id);

    public StoreVO stogerDetail(Integer id);

    //查看所有的店铺及该店铺下商品 用户
    List<StoreGoodsVO> getStoreGoods(Integer type);

    List<StoreVO> invalidStoreList(Integer userId);
}
