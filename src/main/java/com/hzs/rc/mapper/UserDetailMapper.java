package com.hzs.rc.mapper;

import com.hzs.rc.dto.UserDetailDTO;
import com.hzs.rc.entity.UserDetail;
import com.hzs.rc.vo.UserDetailVO;

public interface UserDetailMapper {
    int insertUserDetail(UserDetail record);

    UserDetailVO getUserDetail(Integer userId);

    int simpleInsertUserDetail(UserDetail record);

    void setPlantSpent(UserDetailDTO userDetailDTO);

    void updateUserDetail(UserDetail userDetail);
}