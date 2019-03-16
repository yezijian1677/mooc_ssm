package com.blogs.pojo;

public class Photo {
    private Integer photoId;

    private String photoPath;

    public Photo(Integer photoId, String photoPath) {
        this.photoId = photoId;
        this.photoPath = photoPath;
    }

    public Photo() {
        super();
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }
}