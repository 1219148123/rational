package com.hzs.rc.mapper;

import com.hzs.rc.entity.Admin;

public interface AdminMapper {
    int insertAdmin(Admin record);

    Admin login(Admin admin);

    String getUserPassword(Admin admin);
}