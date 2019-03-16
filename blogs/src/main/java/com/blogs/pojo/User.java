package com.blogs.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String nickename;

    private String userAvatar;

    private String userPhone;

    private Integer userSex;

    private String userEmail;

    private Date regTime;

    private Date latestLoginTime;

    private Integer userStatus;

    private String userDescription;

    public User(Integer userId, String userName, String password, String nickename, String userAvatar, String userPhone, Integer userSex, String userEmail, Date regTime, Date latestLoginTime, Integer userStatus, String userDescription) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.nickename = nickename;
        this.userAvatar = userAvatar;
        this.userPhone = userPhone;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.regTime = regTime;
        this.latestLoginTime = latestLoginTime;
        this.userStatus = userStatus;
        this.userDescription = userDescription;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickename() {
        return nickename;
    }

    public void setNickename(String nickename) {
        this.nickename = nickename == null ? null : nickename.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Date latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription == null ? null : userDescription.trim();
    }

}