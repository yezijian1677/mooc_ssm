package com.curtains.blog_jsp.dao;

import com.curtains.blog_jsp.entity.Article;
import org.springframework.stereotype.Repository;


@Repository("articleMapper")
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}