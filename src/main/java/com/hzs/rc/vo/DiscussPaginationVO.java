package com.hzs.rc.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年04月30日
 */
@Data
public class DiscussPaginationVO {
    List<DiscussVO> discussVOList; //每页的具体数据
    private boolean showPrevious; //前一页
    private boolean showNext; //下一页
    private boolean showFirstPage; //首页
    private boolean showEndPage; //尾页
    private Integer page; //当前请求页
    private Integer totalPage;//总页数
    private List<Integer> pages = new ArrayList<>(); //相关页数

    public void setPagintaion(Integer totalPage, Integer page, Integer size) {
       this.totalPage = totalPage;
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //是否展示前一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否展示第一页 及尾页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
