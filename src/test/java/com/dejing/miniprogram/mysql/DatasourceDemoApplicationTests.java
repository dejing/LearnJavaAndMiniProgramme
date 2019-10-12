package com.dejing.miniprogram.mysql;

import com.dejing.miniprogram.mapper.article.Article;
import com.dejing.miniprogram.service.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@Slf4j
@MapperScan(basePackages = {"com.dejing.miniprogram.mapper.article", "com.dejing.miniprogram.mapper"})
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceDemoApplicationTests {

  @Autowired
  private MemberServiceImpl memberService;

  @Test
  public void testWrite() {
    Article article = new Article();
    //article.setId(100L);
    article.setAuthor("zhangsan");
    article.setContent("Expo and so on");
    article.setTitle("ttest");
    article.setCreateTime(new Date());
    for (int i = 0; i < 2; i++) {
      memberService.insert(article);

    }
    //memberService.insert(article);
  }

  @Test
  public void testRead() {
    List<Article> articles = memberService.selectAll();
    for (Article a : articles) {
      log.info(a.getId() + "\t" + a.getCreateTime());
    }
  }

  @Test
  public void testSave() {
    Article article = new Article();
    article.setAuthor("zhangsan");
    article.setContent("Expo and so on");
    article.setTitle("ttest");
    article.setCreateTime(new Date());

    memberService.save(article);
  }
//
//  @Test
//  public void testReadFromMaster() {
//    memberService.getToken("1234");
//  }
}
