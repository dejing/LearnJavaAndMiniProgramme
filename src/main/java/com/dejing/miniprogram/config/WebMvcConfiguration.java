package com.dejing.miniprogram.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        log.info("WebMvcConfiguration.addInterceptors begin");
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
        log.info("WebMvcConfiguration.addInterceptors end");

    }

    @Bean
    public static HandlerInterceptor getHandlerInterceptor(){
        return  new CustomHandlerInterceptor();
    }
}
