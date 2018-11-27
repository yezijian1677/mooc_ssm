package com.imooc.hsp.service;

import com.imooc.hsp.entity.User;

public interface SelfService {
    User login(String username, String password);

}
