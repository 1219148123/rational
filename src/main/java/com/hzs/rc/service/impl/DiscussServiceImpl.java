package com.hzs.rc.service.impl;

import com.hzs.rc.dto.DiscussDTO;
import com.hzs.rc.entity.Discuss;
import com.hzs.rc.mapper.DiscussMapper;
import com.hzs.rc.service.DiscussService;
import com.hzs.rc.vo.DiscussVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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

    @Override
    public void update(DiscussDTO discussDTO) {
        Discuss discuss = new Discuss();
        BeanUtils.copyProperties(discussDTO, discuss);
        discussMapper.update(discuss);
    }
}
