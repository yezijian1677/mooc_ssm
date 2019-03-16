package com.blogs.dao;

import com.blogs.pojo.UserStar;

public interface UserStarMapper {
    int deleteByPrimaryKey(Integer starId);

    int insert(UserStar record);

    int insertSelective(UserStar record);

    UserStar selectByPrimaryKey(Integer starId);

    int updateByPrimaryKeySelective(UserStar record);

    int updateByPrimaryKey(UserStar record);
}