package com.blogs.service;

import com.blogs.common.ServerResponse;
import com.blogs.pojo.User;

public interface UserService {
    ServerResponse<User> login(String userName, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str, String type);
    ServerResponse<User> updateInformation(User user);
    ServerResponse<User> getInformation(Integer userId);
}
