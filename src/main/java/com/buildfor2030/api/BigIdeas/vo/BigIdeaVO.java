package com.buildfor2030.api.BigIdeas.vo;

import com.buildfor2030.api.BigIdeas.model.BigIdea;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BigIdeaVO {

    private Long id;

    private String name;

    private String slug;

    private String imageUrl;

    private String partners;

    private String essentialQuestions;

    private Date createdAt;

    private Integer followersCount;

    private List<BuilderVO> followers = new ArrayList<>();

    private Integer questionsCount;

    private Integer solutionIdeasCount;

    public BigIdeaVO(BigIdea bigIdea) {
        BeanUtils.copyProperties(bigIdea, this);
        this.followersCount = bigIdea.getFollowersCount();
        this.followers = bigIdea.getFollowerList();
        this.questionsCount = bigIdea.getQuestionsCount();
        this.solutionIdeasCount = bigIdea.getSolutionIdeasCount();
    }

    public BigIdeaVO() {
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPartners() {
        return partners;
    }

    public void setPartners(String partners) {
        this.partners = partners;
    }

    public String getEssentialQuestions() {
        return essentialQuestions;
    }

    public void setEssentialQuestions(String essentialQuestions) {
        this.essentialQuestions = essentialQuestions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public Integer getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(Integer questionsCount) {
        this.questionsCount = questionsCount;
    }

    public Integer getSolutionIdeasCount() {
        return solutionIdeasCount;
    }

    public void setSolutionIdeasCount(Integer solutionIdeasCount) {
        this.solutionIdeasCount = solutionIdeasCount;
    }
}
