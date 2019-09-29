package com.dejing.miniprogram.controller;

import com.dejing.miniprogram.customListener.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class ListenerController {

  @Resource private ApplicationContext applicationContext;

  @RequestMapping("/publish")
  public String hello() {
    log.info(String.format("%s.%s Start",this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName()));
    // todo: 业务处理
    applicationContext.publishEvent(new MyEvent("测试发送邮件事件."));

    return "ok";
  }
}
