package com.dejing.miniprogram.controller;


import com.dejing.miniprogram.config.exception.AjaxResponse;
import com.dejing.miniprogram.service.ExceptionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class HelloController {
    @Resource
    ExceptionService exceptionService;

    @ApiOperation(value = "Get Return succeed", notes = "")
    @RequestMapping("/ex/system")
    public @ResponseBody  AjaxResponse system(){
        exceptionService.systemBizError();
        return AjaxResponse.success();
    }


    @ApiOperation(value = "Get user info", notes = "")
    @ApiImplicitParam(paramType="query", name = "input", value = "用户编号", required = true, dataType = "Integer")
    @RequestMapping("/ex/user/{input}")
    public @ResponseBody  AjaxResponse user(@PathVariable Integer input){

        return AjaxResponse.success(exceptionService.userBizError(input));
    }
}
