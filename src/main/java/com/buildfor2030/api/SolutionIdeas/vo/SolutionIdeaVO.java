package com.buildfor2030.api.SolutionIdeas.vo;

import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.PartnerAPIs.PartnerAPIVO;
import com.buildfor2030.api.SolutionIdeas.model.SolutionIdea;
import com.buildfor2030.api.SolutionIdeas.model.Stack;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class SolutionIdeaVO {

    private Long id;

    private BigIdeaVO bigIdea;

    private BuilderVO builder;

    private String name;

    private String imageUrl;

    private String demoUrl;

    private String repoUrl;

    private String description;

    private List<PartnerAPIVO> apis = new ArrayList<>();

    private Set<Stack> stacks = new HashSet<>();

    private Date createdAt;

    private Boolean isFeatured;

    private Integer updatesCount;

    private Integer supportersCount;

    private Integer commentsCount;

    public SolutionIdeaVO(SolutionIdea idea) {
        BeanUtils.copyProperties(idea, this);
        this.bigIdea = idea.getBigIdeaVO();
        this.builder = idea.getBuilderVO();
        this.apis = idea.getAPIList();
        this.updatesCount = idea.getUpdatesCount();
        this.supportersCount = idea.getSupportersCount();
        this.commentsCount = idea.getCommentsCount();
    }

    public SolutionIdeaVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigIdeaVO getBigIdea() {
        return bigIdea;
    }

    public void setBigIdea(BigIdeaVO bigIdea) {
        this.bigIdea = bigIdea;
    }

    public BuilderVO getBuilder() {
        return builder;
    }

    public void setBuilder(BuilderVO builder) {
        this.builder = builder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PartnerAPIVO> getAPIs() {
        return apis;
    }

    public void setAPIs(List<PartnerAPIVO> apis) {
        this.apis = apis;
    }

    public Set<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(Set<Stack> stacks) {
        this.stacks = stacks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public Integer getUpdatesCount() {
        return updatesCount;
    }

    public void setUpdatesCount(Integer updatesCount) {
        this.updatesCount = updatesCount;
    }

    public Integer getSupportersCount() {
        return supportersCount;
    }

    public void setSupportersCount(Integer supportersCount) {
        this.supportersCount = supportersCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }
}
