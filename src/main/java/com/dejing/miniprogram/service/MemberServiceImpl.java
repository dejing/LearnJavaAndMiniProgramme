package com.dejing.miniprogram.service;

import com.dejing.miniprogram.annotation.Master;
import com.dejing.miniprogram.mapper.article.Article;
import com.dejing.miniprogram.mapper.article.ArticleDao;
import com.dejing.miniprogram.mapper.article.ArticleExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl {
  @Resource
  private ArticleDao articleDao;

  @Transactional
  //@Override
  public int insert(Article member) {
    return articleDao.insert(member);
  }

  //@Master
  //@Override
  public int save(Article member) {
    return articleDao.insert(member);
  }

  //@Override
  public List<Article> selectAll() {
    return articleDao.selectByExample(new ArticleExample());
  }

  //@Master
  //@Override
//  public String getToken(String appId) { //  有些读操作必须读主数据库
//    //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
//    //  这种情况下就必须强制从主数据读
//    return null;
//  }
}
