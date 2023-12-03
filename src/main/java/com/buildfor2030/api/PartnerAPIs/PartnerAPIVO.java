package com.buildfor2030.api.PartnerAPIs;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class PartnerAPIVO {

    private Long id;

    private String name;

    private String slug;

    private String websiteUrl;

    private String description;

    private List<String> categories = new ArrayList<>();

    public PartnerAPIVO(PartnerAPI api) {
        BeanUtils.copyProperties(api, this);
        this.categories = api.getCategoryNameList();
    }

    public PartnerAPIVO() {
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

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
