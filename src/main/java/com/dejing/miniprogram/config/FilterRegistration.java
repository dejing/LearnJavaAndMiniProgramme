package com.dejing.miniprogram.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterRegistration {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(customFilter());
        registrationBean.setName("customerFilter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(10);
        return  registrationBean;
    }
    @Bean
    public Filter customFilter(){
        return new CustomFilter();
    }



    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(customFilter2());
        registrationBean.setName("customerFilter2");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(9);
        return  registrationBean;
    }
    @Bean
    public Filter customFilter2(){
        return new CustomFilter2();
    }
}
