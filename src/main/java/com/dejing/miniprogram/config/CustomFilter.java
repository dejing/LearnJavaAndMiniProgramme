package com.dejing.miniprogram.config;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "customFilter", urlPatterns = {"/*"})
@Slf4j
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomFilter Initialzer");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("CustomFilter Before ");
        //可以对request，response进行一些处理
        //比如设置请求编码
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        //链路，直接传给下一个过滤器
        chain.doFilter(request,response);
        log.info("CustomFilter end");

    }

    @Override
    public void destroy() {
        log.info("CustomFilter Destroy!!!!");

    }
}
