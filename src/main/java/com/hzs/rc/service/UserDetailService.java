package com.hzs.rc.service;

import com.hzs.rc.dto.UserDetailDTO;
import com.hzs.rc.entity.User;
import com.hzs.rc.vo.UserDetailVO;

/**
 * <p>接口</p>
 *
 * @author :  hzs 2020年01月21日
 * @version : 1.0
 */
public interface UserDetailService {
    UserDetailVO getUserDetail(Integer userId);

    Integer insertUserDetailForSignUp(User user);

    void setUserPlantSpent(UserDetailDTO userDetailDTO);

    void updateUserDetail(UserDetailDTO userDetailDTO);

    void updateCurSpent(Integer userId,Double userCurrentSpent);

    void updateUserSpent(UserDetailDTO userDetailDTO);

}
