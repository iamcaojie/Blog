package com.imcaojie.task;

import com.imcaojie.utils.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author caojie
 * @className MinuteTask
 * @description
 **/

@Component
public class MinuteTask {

    @Scheduled(cron = "0/3 * * * * ?")
    public void test() {
        System.out.println(
                "执行定时任务，当前时间为："
                + DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
    }
}
