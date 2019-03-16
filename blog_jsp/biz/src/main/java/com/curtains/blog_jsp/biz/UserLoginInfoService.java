package com.curtains.blog_jsp.biz;

import com.curtains.blog_jsp.entity.UserLoginInfo;

import java.util.List;

public interface UserLoginInfoService {

    List<UserLoginInfo> selectLoginRecord(Integer userId);

    int insert(UserLoginInfo userLoginInfo);

    int selectCountByUserId(int userId);
}
