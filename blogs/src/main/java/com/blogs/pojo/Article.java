package com.blogs.pojo;

import java.util.Date;

public class Article {
    private Integer articleId;

    private String articleTitle;

    private Integer userId;

    private Integer articleCount;

    private Integer articleType;

    private Date articleTime;

    private String articleContent;

    public Article(Integer articleId, String articleTitle, Integer userId, Integer articleCount, Integer articleType, Date articleTime, String articleContent) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.userId = userId;
        this.articleCount = articleCount;
        this.articleType = articleType;
        this.articleTime = articleTime;
        this.articleContent = articleContent;
    }

    public Article() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}