package com.blogs.pojo;

import java.util.Date;

public class SystemMessage {
    private Integer noticeId;

    private Integer userId;

    private Integer isRead;

    private Date noticeTime;

    private String noticeDesc;

    public SystemMessage(Integer noticeId, Integer userId, Integer isRead, Date noticeTime, String noticeDesc) {
        this.noticeId = noticeId;
        this.userId = userId;
        this.isRead = isRead;
        this.noticeTime = noticeTime;
        this.noticeDesc = noticeDesc;
    }

    public SystemMessage() {
        super();
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeDesc() {
        return noticeDesc;
    }

    public void setNoticeDesc(String noticeDesc) {
        this.noticeDesc = noticeDesc == null ? null : noticeDesc.trim();
    }
}