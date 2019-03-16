package com.blogs.pojo;

import java.util.Date;

public class Comment {
    private Integer articleId;

    private Integer userId;

    private Date createTime;

    private String commentContent;

    public Comment(Integer articleId, Integer userId, Date createTime, String commentContent) {
        this.articleId = articleId;
        this.userId = userId;
        this.createTime = createTime;
        this.commentContent = commentContent;
    }

    public Comment() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}