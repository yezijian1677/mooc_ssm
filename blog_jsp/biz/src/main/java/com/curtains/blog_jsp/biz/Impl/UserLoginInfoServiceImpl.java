package com.curtains.blog_jsp.biz.Impl;

import com.curtains.blog_jsp.dao.UserLoginInfoMapper;
import com.curtains.blog_jsp.entity.UserLoginInfo;
import com.curtains.blog_jsp.biz.UserLoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userLoginInfoService")
public class UserLoginInfoServiceImpl implements UserLoginInfoService {

    @Resource(name = "userLoginInfoMapper")
    private UserLoginInfoMapper userLoginInfoMapper;

    public List<UserLoginInfo> selectLoginRecord(Integer userId) {
        return userLoginInfoMapper.selectLoginRecord(userId);
    }

    public int insert(UserLoginInfo userLoginInfo) {
        return userLoginInfoMapper.insert(userLoginInfo);
    }

    public int selectCountByUserId(int userId) {
        return userLoginInfoMapper.selectCountByUserId(userId);
    }
}
