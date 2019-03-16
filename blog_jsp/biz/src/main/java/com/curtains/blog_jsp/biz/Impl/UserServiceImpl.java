package com.curtains.blog_jsp.biz.Impl;

import com.curtains.blog_jsp.dao.UserMapper;
import com.curtains.blog_jsp.entity.User;
import com.curtains.blog_jsp.biz.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
