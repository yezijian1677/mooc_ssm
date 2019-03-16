package com.curtains.blog_jsp.dao;

import com.curtains.blog_jsp.entity.UserLoginInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userLoginInfoMapper")
public interface UserLoginInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLoginInfo record);

    int insertSelective(UserLoginInfo record);

    UserLoginInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLoginInfo record);

    int updateByPrimaryKey(UserLoginInfo record);

    List<UserLoginInfo> selectLoginRecord(Integer userId);

    int selectCountByUserId(Integer userId);
}