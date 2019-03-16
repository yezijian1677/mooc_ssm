package com.blogs.service.Impl;

import com.blogs.common.Const;
import com.blogs.common.ServerResponse;
import com.blogs.dao.UserMapper;
import com.blogs.pojo.User;
import com.blogs.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String userName, String password){
        System.out.println(userName+"+"+password);
        int resultCount = userMapper.checkUserName(userName);
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("用户不存在");
        }

        User user = userMapper.selectLogin(userName, password);
        if (user==null){
            return ServerResponse.createByErrorMessage("密码错误");
        }

        return  ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(User user){
        ServerResponse validResponse = this.checkValid(user.getUserName(),Const.USERNAME);
        if (!validResponse.isSuccess()){
            return validResponse;
        }

        validResponse = this.checkValid(user.getUserEmail(),Const.EMAIL);
        if (!validResponse.isSuccess()){
            return validResponse;
        }
        user.setUserStatus(0);
        user.setUserSex(2);
        user.setRegTime(new Date());
        user.setLatestLoginTime(new Date());

        int resultCount = userMapper.insert(user);
        if (resultCount ==0){
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createByErrorMessage("注册成功");

    }

    @Override
    public ServerResponse<String> checkValid(String str, String type){
        if (StringUtils.isNotBlank(type)){
            //开始校验
            if (Const.USERNAME.equals(type)) {
                int resultCount = userMapper.checkUserName(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户已存在");
                }
            }
            if (Const.EMAIL.equals(type)){
                int resultCount = userMapper.checkUserEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("email已存在");
                }
            }

        }else {
            return  ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }


    @Override
    public ServerResponse<User> updateInformation(User user){
        int resultCount = userMapper.checkEmailByUserId(user.getUserEmail(), user.getUserId());
        if (resultCount>0){
            return ServerResponse.createByErrorMessage("email已存在，请更换email再尝试更新");
        }
        User updateUser = new User();
        updateUser.setUserId(user.getUserId());
        updateUser.setUserEmail(user.getUserEmail());
        updateUser.setUserPhone(user.getUserPhone());
        updateUser.setUserSex(user.getUserSex());
        updateUser.setUserAvatar(user.getUserAvatar());
        updateUser.setUserDescription(user.getUserDescription());
        updateUser.setLatestLoginTime(new Date());

        int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);
        if (updateCount > 0){
            return ServerResponse.createBySuccess("更新个人信息成功", updateUser);
        }
        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }

    @Override
    public ServerResponse<User> getInformation(Integer userId){
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null){
            return ServerResponse.createByErrorMessage("找不到用户");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }
}
