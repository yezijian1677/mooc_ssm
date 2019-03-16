package com.blogs.dao;

import com.blogs.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}