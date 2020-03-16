package com.hzs.rc.controller.admin;

import com.hzs.rc.dto.CategoryDTO;
import com.hzs.rc.service.CategoryService;
import com.hzs.rc.vo.CategoryVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月16日
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @ApiOperation(value = "添加类别", notes = "添加分类")
    @PostMapping("/add")
    public void insertCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        categoryService.addCartegory(categoryDTO);
    }

    @ApiOperation(value = "查询类别", notes = "查询分类")
    @GetMapping("/get")
    public List<CategoryVO> getCategory(){
        return categoryService.categoryList();
    }
}
