package com.hzs.rc.mapper;

import com.hzs.rc.entity.Category;
import com.hzs.rc.vo.CategoryVO;

import java.util.List;

public interface CategoryMapper {
    int addCate(Category record);

    List<CategoryVO> getCateGoryVOList();
}