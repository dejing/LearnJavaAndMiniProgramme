package com.dejing.miniprogram.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BlogProperties {
    @Value("${com.blog.name}")
    private String name;
    @Value("${com.blog.title}")
    private String title;
    @Value("${com.blog.desc}")
    private String desc;
    @Value("${com.blog.value}")
    private String value;
    @Value("${com.blog.number}")
    private String number;
    @Value("${com.blog.bignumber}")
    private String bignumber;
    @Value("${com.blog.less10}")
    private int less10;
    @Value("${com.blog.less20}")
    private int less20;
}
