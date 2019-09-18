package com.dejing.miniprogram.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(value = "/servlet")
public class MyServlet extends HttpServlet {
    public MyServlet(){
        System.out.println("my Servlet Class");
        log.info("my Servlet Class");
    }
//
//    @Override
//    protected void  service(HttpServletRequest request, HttpServletResponse response){
//        System.out.println("servlet service method!");
//        log.info("servlet service method!");
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("MyServlet");
        log.info("servlet doGet method!");
    }

}
