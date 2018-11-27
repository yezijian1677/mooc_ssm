package com.imooc.hsp.dao;

import com.imooc.hsp.entity.User;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
public interface SelfDao {
    User selectByUser(String username);
}
