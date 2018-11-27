package com.imooc.hsp.service.Impl;

import com.imooc.hsp.dao.SelfDao;
import com.imooc.hsp.entity.User;
import com.imooc.hsp.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfDao selfDao;
    public User login(String username, String password) {
        User user = selfDao.selectByUser(username);
        if (user == null) {
            return null;
        }
        if(user.getPassword().equals(password)){
            return user;
        }

        return null;
    }
}
