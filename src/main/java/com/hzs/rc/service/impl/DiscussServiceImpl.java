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
        int totalCount = discussMapper.getCount();
        int totalPage = 0;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size - 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        int offset = size * (page -1);
        DiscussPaginationVO discussPaginationVO = new DiscussPaginationVO();
        discussPaginationVO.setPagintaion(totalCount,page,size);
        List<DiscussVO> discussVOS = discussMapper.discussMng(offset, size);
        discussPaginationVO.setDiscussVOList(discussVOS);
        return discussPaginationVO;
    }
}
