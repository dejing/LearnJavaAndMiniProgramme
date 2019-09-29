package com.dejing.miniprogram.customListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        // 发送邮件处理
        log.info(String.format("%s 监听到事件源：%s.", MyListener2.class.getName(),event.getSource()));
    }
}
