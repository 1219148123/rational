package com.hzs.rc.service.impl;

import com.hzs.rc.dto.CategoryDTO;
import com.hzs.rc.entity.Category;
import com.hzs.rc.mapper.CategoryMapper;
import com.hzs.rc.service.CategoryService;
import com.hzs.rc.vo.CategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月16日
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;
    @Override
    public void addCartegory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        categoryMapper.addCate(category);
    }

    @Override
    public List<CategoryVO> categoryList() {
        List<CategoryVO> cateGoryVOList = categoryMapper.getCateGoryVOList();
        return cateGoryVOList;
    }
}
