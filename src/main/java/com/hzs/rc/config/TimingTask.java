package com.hzs.rc.config;

import com.hzs.rc.mapper.CommentMapper;
import com.hzs.rc.mapper.UserDetailMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TimingTask {
    /**
     *  每五秒执行一次
     */
    @Resource
    UserDetailMapper userDetailMapper;

    @Scheduled(cron="0 15 10 15 * ?")
    public void executeFileDownLoadTask() {
        userDetailMapper.setCurSpentBlank();
        System.out.println("每月15日上午10:15触发,所有用户当前消费为空");
    }
}
