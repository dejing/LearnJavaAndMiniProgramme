package com.dejing.miniprogram.config;

import com.dejing.miniprogram.model.EchoServerTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class TaskSchedulerConfig implements SchedulingConfigurer {

    public class myTask extends TimerTask {

    @Override
    public void run() {
      System.out.println("The current time is " + System.currentTimeMillis() + ".");
            }
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskScheduler());
    }

    @Bean(destroyMethod = "shutdown")
    Executor taskScheduler() {
         return (Executor) Executors.newScheduledThreadPool(100).
                 scheduleAtFixedRate(new myTask(), 5000, 5000, TimeUnit.MILLISECONDS);
    }

}
