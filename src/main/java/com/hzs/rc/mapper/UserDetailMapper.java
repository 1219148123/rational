package com.hzs.rc.mapper;

import com.hzs.rc.dto.UserDetailDTO;
import com.hzs.rc.entity.UserDetail;
import com.hzs.rc.vo.UserDetailVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

public interface UserDetailMapper {
    int insertUserDetail(UserDetail record);

    UserDetailVO getUserDetail(Integer userId);

    int simpleInsertUserDetail(UserDetail record);

    void setPlantSpent(UserDetailDTO userDetailDTO);

    void updateUserDetail(UserDetail userDetail);

    void  openStore(Integer userId);

    void updateCurSpent(@Param(value = "userId")Integer userId, @Param(value = "spent")Double spent);
}
