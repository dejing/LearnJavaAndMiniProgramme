package com.dejing.miniprogram.service;

import com.dejing.miniprogram.annotation.Master;
import com.dejing.miniprogram.mapper.article.Article;
import com.dejing.miniprogram.mapper.article.ArticleDao;
import com.dejing.miniprogram.mapper.article.ArticleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.DefaultScriptExecutor;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.core.script.ScriptExecutor;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MemberServiceImpl {
  @Resource
  private ArticleDao articleDao;
  @Autowired
  private RedisTemplate redisTemplate;


  @Transactional
  //@Override
  public int insert(Article article) {
    ValueOperations<String, Article> operations = redisTemplate.opsForValue();
    int result = articleDao.insert(article);
    if (result != 0) {
      String key = "article_" + article.getId();
      boolean haskey = redisTemplate.hasKey(key);
      if (haskey) {
        redisTemplate.delete(key);
        System.out.println("删除缓存中的key=========>" + key);
      }
      // 再将更新后的数据加入缓存
      Article userNew = articleDao.selectByPrimaryKey(article.getId());
      if (userNew != null) {
        operations.set(key, userNew, 3, TimeUnit.HOURS);
      }
    }
    return result;
  }

  //@Master
  //@Override
  public int save(Article member) {
    return insert(member);
  }

  public Article selectById(Long id){

    String key = "article_" + id;
    ValueOperations<String, Article> ops = redisTemplate.opsForValue();


    //ListOperations<String,String>opsForList = redisTemplate.opsForList();



    boolean hasKey = redisTemplate.hasKey(key);
    if (hasKey){
      long start = System.currentTimeMillis();
      Article article = ops.get(key);
      System.out.println("==========从缓存中获得数据=========");
      System.out.println(article.getAuthor());
      System.out.println("==============================");
      long end = System.currentTimeMillis();
      System.out.println("查询redis花费的时间是:" + (end - start)+"ms");
      return article;
    }else{
      long start = System.currentTimeMillis();
      Article article = articleDao.selectByPrimaryKey(id);
      System.out.println("==========从数据表中获得数据=========");
      System.out.println(article.getAuthor());
      System.out.println("==============================");

      ops.set(key, article, 5, TimeUnit.HOURS);

      long end = System.currentTimeMillis();
      System.out.println("查询mysql花费的时间是:" + (end - start)+"ms");

      return  article;
    }

  }
  //@Override
  public List<Article> selectAll() {
    return articleDao.selectByExample(new ArticleExample());
  }

  public int deleteArticle(Long id){
    int result = articleDao.deleteByPrimaryKey(id);
    String key = "article_" + id;
    if (result != 0) {
      boolean hasKey = redisTemplate.hasKey(key);
      if (hasKey) {
        redisTemplate.delete(key);
        System.out.println("删除了缓存中的key:" + key);
      }
    }
    return result;
  }

  //@Master
  //@Override
//  public String getToken(String appId) { //  有些读操作必须读主数据库
//    //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
//    //  这种情况下就必须强制从主数据读
//    return null;
//  }
}
