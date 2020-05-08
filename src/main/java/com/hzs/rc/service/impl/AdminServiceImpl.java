package com.hzs.rc.service.impl;

import com.hzs.rc.entity.Admin;
import com.hzs.rc.entity.User;
import com.hzs.rc.mapper.AdminMapper;
import com.hzs.rc.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年05月08日
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Override
    public int insertAdmin(Admin record) {
        return adminMapper.insertAdmin(record);
    }

    @Override
    public Integer login(Admin admin) {
        Admin ad = adminMapper.login(admin);
        if (ad == null) {
            return 0;//账号不存在
        } else if (admin.getAdminPassword().equals(adminMapper.getUserPassword(admin))) {
            return 1;
        }
        return -1;//账号密码匹配失败
    }
}
