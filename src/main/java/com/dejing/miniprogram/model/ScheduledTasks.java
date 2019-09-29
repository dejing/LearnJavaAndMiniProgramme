package com.dejing.miniprogram.model;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class ScheduledTasks {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000, initialDelay = 2000)
    public void reportCurrentTime0(){
      log.info("reportCurrentTime0,当前时间："+dateFormat.format(new Date()));
    }


    @Scheduled(cron = "${time.cron}")
    public void reportCurrentTime(){
        log.info("reportCurrentTime,当前时间："+dateFormat.format(new Date()));
    }

    @Scheduled(cron = "*/${time.interval} * * * * *")
    public void testInterval(){
        log.info("testInterval,当前时间："+dateFormat.format(new Date()));
    }
}
