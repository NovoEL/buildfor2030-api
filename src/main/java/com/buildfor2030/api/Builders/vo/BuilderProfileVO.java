package com.buildfor2030.api.Builders.vo;

import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuilderProfileVO {

    private Long id;

    private String name;

    private String username;

    private String avatarUrl;

    private String bio;

    private Date createdAt;

    private Date updatedAt;

    private Integer ideasCount;

    private List<SolutionIdeaVO> ideas = new ArrayList<>();

    private Integer followersCount;

    private List<BuilderVO> followers = new ArrayList<>();

    private Integer followingCount;

    private List<BuilderVO> following = new ArrayList<>();

    private Integer bigIdeaFollowingCount;

    private List<BigIdeaVO> bigIdeaFollowing = new ArrayList<>();

    private Integer supportingCount;

    private List<SolutionIdeaVO> supporting = new ArrayList<>();

    private Integer bookmarksCount;

    private BookmarksVO bookmarks;

    public BuilderProfileVO(Builder builder) {
        BeanUtils.copyProperties(builder, this);
        this.ideasCount = builder.getIdeasCount();
        this.ideas = builder.getIdeaList();
        this.followersCount = builder.getFollowersCount();
        this.followers = builder.getFollowerList();
        this.followingCount = builder.getFollowingCount();
        this.following = builder.getFollowingList();
        this.bigIdeaFollowingCount = builder.getBigIdeaFollowingCount();
        this.bigIdeaFollowing = builder.getBigIdeaFollowingList();
        this.supportingCount = builder.getSupportingCount();
        this.supporting = builder.getSupportingList();
        this.bookmarksCount = builder.getBookmarksCount();
        this.bookmarks = builder.getBookmarksVO();
    }

    public BuilderProfileVO() {
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

    public List<SolutionIdeaVO> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<SolutionIdeaVO> ideas) {
        this.ideas = ideas;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public List<BuilderVO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<BuilderVO> followers) {
        this.followers = followers;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public List<BuilderVO> getFollowing() {
        return following;
    }

    public void setFollowing(List<BuilderVO> following) {
        this.following = following;
    }

    public Integer getBigIdeaFollowingCount() {
        return bigIdeaFollowingCount;
    }

    public void setBigIdeaFollowingCount(Integer bigIdeaFollowingCount) {
        this.bigIdeaFollowingCount = bigIdeaFollowingCount;
    }

    public List<BigIdeaVO> getBigIdeaFollowing() {
        return bigIdeaFollowing;
    }

    public void setBigIdeaFollowing(List<BigIdeaVO> bigIdeaFollowing) {
        this.bigIdeaFollowing = bigIdeaFollowing;
    }

    public Integer getSupportingCount() {
        return supportingCount;
    }

    public void setSupportingCount(Integer supportingCount) {
        this.supportingCount = supportingCount;
    }

    public List<SolutionIdeaVO> getSupporting() {
        return supporting;
    }

    public void setSupporting(List<SolutionIdeaVO> supporting) {
        this.supporting = supporting;
    }

    public Integer getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(Integer bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public BookmarksVO getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(BookmarksVO bookmarks) {
        this.bookmarks = bookmarks;
    }
}
