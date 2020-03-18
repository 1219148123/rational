package com.hzs.rc.service;

import com.hzs.rc.dto.StoreDTO;
import com.hzs.rc.vo.StoreVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年03月10日
 * @version : 1.0
 */
public interface StoreService {
    public void inserStore(StoreDTO storeDTO, MultipartFile file);

    public List<StoreVO> storeList(Integer userId);

    public void updateStore(StoreDTO storeDTO, MultipartFile file);

    public void invalidStore(Integer id);

    public StoreVO stogerDetail(Integer id);
}
