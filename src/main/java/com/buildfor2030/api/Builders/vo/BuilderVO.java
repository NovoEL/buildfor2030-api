package com.buildfor2030.api.Builders.vo;

import com.buildfor2030.api.Builders.model.Builder;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BuilderVO {
    private Long id;

    private String name;

    private String username;

    private String avatarUrl;

    private String bio;

    private Date createdAt;

    private Date updatedAt;

    private Integer ideasCount;

    private Integer followersCount;

    private Integer followingCount;

    private Integer bigIdeaFollowingCount;

    private Integer supportingCount;

    private Integer bookmarksCount;

    public BuilderVO(Builder builder) {
        BeanUtils.copyProperties(builder, this);
        this.ideasCount = builder.getIdeasCount();
        this.followersCount = builder.getFollowersCount();
        this.followingCount = builder.getFollowingCount();
        this.bigIdeaFollowingCount = builder.getBigIdeaFollowingCount();
        this.supportingCount = builder.getSupportingCount();
        this.bookmarksCount = builder.getBookmarksCount();
    }

    public BuilderVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getIdeasCount() {
        return ideasCount;
    }

    public void setIdeasCount(Integer ideasCount) {
        this.ideasCount = ideasCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getBigIdeaFollowingCount() {
        return bigIdeaFollowingCount;
    }

    public void setBigIdeaFollowingCount(Integer bigIdeaFollowingCount) {
        this.bigIdeaFollowingCount = bigIdeaFollowingCount;
    }

    public Integer getSupportingCount() {
        return supportingCount;
    }

    public void setSupportingCount(Integer supportingCount) {
        this.supportingCount = supportingCount;
    }

    public Integer getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(Integer bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }
}
