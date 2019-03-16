package com.blogs.pojo;

import java.util.Date;

public class Message {
    private Integer messageId;

    private Integer userId;

    private Date createTime;

    private String content;

    public Message(Integer messageId, Integer userId, Date createTime, String content) {
        this.messageId = messageId;
        this.userId = userId;
        this.createTime = createTime;
        this.content = content;
    }

    public Message() {
        super();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}