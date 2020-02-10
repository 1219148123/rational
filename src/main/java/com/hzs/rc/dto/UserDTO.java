package com.hzs.rc.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年01月21日
 */
@Data
@Component
public class UserDTO {
    private String userAccount;

    private String userPassword;
}
