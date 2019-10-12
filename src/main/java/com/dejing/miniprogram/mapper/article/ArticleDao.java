package com.dejing.miniprogram.mapper.article;

import com.dejing.miniprogram.mapper.article.Article;
import com.dejing.miniprogram.mapper.article.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleDao {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}