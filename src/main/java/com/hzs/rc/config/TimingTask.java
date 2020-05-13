package com.hzs.rc.config;

import com.hzs.rc.controller.GoodController;
import com.hzs.rc.mapper.UserDetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TimingTask {
    @Resource
    UserDetailMapper userDetailMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodController.class);

    @Scheduled(cron = "0 15 10 15 * ?")
    public void executeFileDownLoadTask() {
        userDetailMapper.setCurSpentBlank();
        LOGGER.info("每月15日上午10:15触发,所有用户当前消费为空");
    }
}
