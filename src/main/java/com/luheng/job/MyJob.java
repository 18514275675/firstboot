package com.luheng.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJob {

    @Scheduled(cron = "*/5 * * * * ?")   //使用定时任务,只需要在此处加上注解,并在启动类加上@EnableScheduling注解开启定时,即可
    public void testJob(){
        System.out.println("定时任务 job 开始  " + System.currentTimeMillis());
    }

    @Scheduled(fixedRate = 6000)
    public void job2(){
        System.out.println("<---定时任务 job2 开始  " + System.currentTimeMillis()+"--->");
    }
}
