package com.hzs.rc.service;

import com.hzs.rc.dto.CategoryDTO;
import com.hzs.rc.vo.CategoryVO;

import java.util.List;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年03月16日
 * @version : 1.0
 */
public interface CategoryService {
    void addCartegory(CategoryDTO categoryDTO);

    List<CategoryVO> categoryList();
}
