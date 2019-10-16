package com.dejing.miniprogram.controller;

import com.dejing.miniprogram.mapper.article.Article;
import com.dejing.miniprogram.service.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Resource
    private MemberServiceImpl memberService;

    @RequestMapping("/queryAll")
    public List<Article> queryAll(){
        List<Article> lists = memberService.selectAll();
        return lists;
    }

    @RequestMapping("/findArticleById")
    public Article findArticleById(@RequestParam(value="id" ,required =true )  Long id){
        return memberService.selectById(id);
    }
}
