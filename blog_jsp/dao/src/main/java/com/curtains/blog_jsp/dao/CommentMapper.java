package com.curtains.blog_jsp.dao;

import com.curtains.blog_jsp.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository("commentMapper")
public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}