package com.hzs.rc.service;

import com.hzs.rc.dto.DiscussDTO;
import com.hzs.rc.entity.Discuss;
import com.hzs.rc.vo.DiscussVO;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年04月24日
 */
public interface DiscussService {
    int insert(DiscussDTO discussDTO);

    DiscussVO selectDiscuss(Integer id);

    void update(DiscussDTO discussDTO);
}
