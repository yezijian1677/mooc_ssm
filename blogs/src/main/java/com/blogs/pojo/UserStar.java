package com.blogs.pojo;

public class UserStar {
    private Integer starId;

    private Integer articleId;

    private Integer userId;

    public UserStar(Integer starId, Integer articleId, Integer userId) {
        this.starId = starId;
        this.articleId = articleId;
        this.userId = userId;
    }

    public UserStar() {
        super();
    }

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
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
}