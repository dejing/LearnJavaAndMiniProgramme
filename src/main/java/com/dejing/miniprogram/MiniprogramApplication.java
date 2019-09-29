package com.dejing.miniprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(basePackages = {"com.dejing.miniprogram.mapper"})
@ServletComponentScan
@SpringBootApplication

//启动类启用定时任务
@EnableScheduling
public class MiniprogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniprogramApplication.class, args);
    }

}
