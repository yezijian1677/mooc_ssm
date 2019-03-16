package com.blogs.dao;

import com.blogs.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String username);

    int checkUserEmail(String userEmail);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    int checkEmailByUserId(@Param("userEmail") String userEmail, @Param("userId") Integer userId);
}