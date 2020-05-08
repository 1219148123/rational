package com.hzs.rc.service;

import com.hzs.rc.dto.UserDTO;
import com.hzs.rc.entity.Admin;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年05月08日
 * @version : 1.0
 */
public interface AdminService {
    int insertAdmin(Admin record);

    Integer login(Admin admin);
}
