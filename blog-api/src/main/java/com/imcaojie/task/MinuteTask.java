package com.imcaojie.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author caojie
 * @className MinuteTask
 * @description
 **/

//@Component
public class MinuteTask {

    @Scheduled(cron = "0/3 * * * * ?")
    public void test() {
        System.out.println("");
    }
}
