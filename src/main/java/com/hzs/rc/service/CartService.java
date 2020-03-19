package com.hzs.rc.service;

import com.hzs.rc.dto.CartDTO;
import com.hzs.rc.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年03月19日
 * @version : 1.0
 */
public interface CartService {
    void insertCart(CartDTO cartDTO);

    List<CartVO> getAllCartGood(Integer userId);

    List<CartVO> getAllCheckedCartGood(Integer userId);

    List<CartVO> getAllCartInvalidGood(Integer userId);

    void checkGood(Integer id);

    void checkAll(Integer userId);

    void inCheckAll(Integer userId);

    void changeNum(Integer id,Integer num);

    void deleteCartGood(Integer id);

    void flushCart(Integer userId);
}

