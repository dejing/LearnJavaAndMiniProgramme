package com.dejing.miniprogram.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@Slf4j
@WebListener
public class MyListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent event) {
//        requestInitialized(event);
        log.info("MyListener Init");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event){
//        requestDestroyed(event);
        log.info("MyListener Destory");
    }

}
