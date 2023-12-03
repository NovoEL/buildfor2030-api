package com.buildfor2030.api.SolutionIdeas.dto;

import com.google.common.base.Splitter;

import java.util.List;

public class SolutionIdeaDTO {

    private Long bigIdeaId;

    private String name;

    private String imageUrl;

    private String demoUrl;

    private String repoUrl;

    private String description;

    private String apiSlugs;

    private String stackSlugs;

    public Long getBigIdeaId() {
        return bigIdeaId;
    }

    public void setBigIdeaId(Long bigIdeaId) {
        this.bigIdeaId = bigIdeaId;
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

    public String getApiSlugs() {
        return apiSlugs;
    }

    public void setApiSlugs(String apiSlugs) {
        this.apiSlugs = apiSlugs;
    }

    public String getStackSlugs() {
        return stackSlugs;
    }

    public void setStackSlugs(String stackSlugs) {
        this.stackSlugs = stackSlugs;
    }

    public List<String> getAPISlugList() {
        return Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(apiSlugs);
    }

    public List<String> getStackSlugList() {
        return Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(stackSlugs);
    }
}
