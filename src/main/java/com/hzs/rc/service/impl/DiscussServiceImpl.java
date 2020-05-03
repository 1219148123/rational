package com.hzs.rc.service.impl;

import com.hzs.rc.dto.DiscussDTO;
import com.hzs.rc.entity.Discuss;
import com.hzs.rc.mapper.DiscussMapper;
import com.hzs.rc.service.DiscussService;
import com.hzs.rc.vo.DiscussPaginationVO;
import com.hzs.rc.vo.DiscussVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年04月24日
 */
@Service
public class DiscussServiceImpl implements DiscussService {
    @Resource
    DiscussMapper discussMapper;

    @Override
    public int insert(DiscussDTO discussDTO) {
        Discuss discuss = new Discuss();
        BeanUtils.copyProperties(discussDTO, discuss);
        discuss.setGmtCreate(new Date());
        return discussMapper.insert(discuss);
    }

    /**
     * @描述 文章详情查看, 同时更新浏览次数
     * @参数 [id]
     * @返回值 com.hzs.rc.vo.DiscussVO
     * @创建人 hanzs
     * @创建时间 2020/4/30
     */
    @Transactional
    @Override
    public DiscussVO selectDiscuss(Integer id) {
        Discuss discuss = new Discuss();
        discuss.setViewCount(1);
        discuss.setId(id);
        discuss.setGmtModified(new Date());
        discussMapper.update(discuss);
        discussMapper.updateTime(discuss);
        return discussMapper.selectDiscuss(id);
    }

    @Transactional
    @Override
    public void update(DiscussDTO discussDTO) {
        Discuss discuss = new Discuss();
        BeanUtils.copyProperties(discussDTO, discuss);
        discuss.setGmtModified(new Date());
        discussMapper.update(discuss);
        discussMapper.updateTime(discuss);
    }

    @Override
    public DiscussPaginationVO discussMng(Integer page, Integer size) {
        int totalCount = discussMapper.getCount();//获取所有数据库记录
        int totalPage = 0;//计算总页数
        if (totalCount >= size) {
            if (totalCount % size == 0) {
                totalPage = totalCount / size;
            } else {
                totalPage = totalCount / size + 1;
            }
        }else {
            totalPage = 1;
        }
        //规范输入的页数 小于1 为1 大于最大页数为最大页数
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        int offset = size * (page -1);//计算偏移量
        DiscussPaginationVO discussPaginationVO = new DiscussPaginationVO();
        discussPaginationVO.setPagintaion(totalPage,page,size);//相关前天展示属性赋值
        List<DiscussVO> discussVOS = discussMapper.discussMng(offset, size);//获取数据
        discussPaginationVO.setDiscussVOList(discussVOS);
        return discussPaginationVO;
    }
}
