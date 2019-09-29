package com.dejing.miniprogram.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@ComponentScan(basePackages = "com.dejing.miniprogram.model")
public class BlogPropertiesTest {

  @Resource
  private BlogProperties blogProperties;

  @Test
  public void Test1(){
    Assert.assertEquals( blogProperties.getName(), "Test");
    Assert.assertNotEquals(blogProperties.getTitle(), "no");
    Assert.assertFalse(blogProperties.getLess10()>10);
    Assert.assertFalse(blogProperties.getLess20()>20);

    log.info("Random number output:");
    log.info(blogProperties.getValue());
    log.info(blogProperties.getNumber());
    log.info(blogProperties.getBignumber());

  }
}