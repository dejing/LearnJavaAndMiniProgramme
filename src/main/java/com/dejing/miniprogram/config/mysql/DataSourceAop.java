package com.dejing.miniprogram.config.mysql;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DataSourceAop implements Ordered {
  @Override
  public int getOrder() {
    return 0;
  }

  @Before("readPointcut()")
  public void read() {
    log.info("read");
    DBContextHolder.slave();
  }
  //
  //    @Pointcut("@annotation(com.dejing.miniprogram.config.mysql.UseSlaveDatabase)")
  //    public void readPointcut() {
  //    }

  @Pointcut(
      "!@annotation(com.dejing.miniprogram.annotation.Master) "
          + "&& (execution(* com.dejing.miniprogram.service..*.select*(..)) "
          + "|| execution(* com.dejing.miniprogram.service..*.get*(..)))")
  public void readPointcut() {}

  @Pointcut(
      "@annotation(com.dejing.miniprogram.annotation.Master) "
          + "|| execution(* com.dejing.miniprogram.service..*.insert*(..)) "
          + "|| execution(* com.dejing.miniprogram.service..*.add*(..)) "
          + "|| execution(* com.dejing.miniprogram.service..*.save*(..)) "
          + "|| execution(* com.dejing.miniprogram.service..*.update*(..)) "
          + "|| execution(* com.dejing.miniprogram.service..*.edit*(..)) "
          + "|| execution(* com.dejing.miniprogram.service..*.delete*(..)) "
          + "|| execution(* com.dejing.miniprogram.service..*.remove*(..))")
  public void writePointcut() {}

  @Before("writePointcut()")
  public void write() {
    DBContextHolder.master();
  }
}
