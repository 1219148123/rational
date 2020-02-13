package com.hzs.rc.mapper;

import com.hzs.rc.dto.UserDetailDTO;
import com.hzs.rc.entity.UserDetail;

public interface UserDetailMapper {
    int insertUserDetail(UserDetail record);

    int simpleInsertUserDetail(UserDetail record);

    void setPlantSpent(UserDetailDTO userDetailDTO);

    void updateUserDetail(UserDetail userDetail);
}