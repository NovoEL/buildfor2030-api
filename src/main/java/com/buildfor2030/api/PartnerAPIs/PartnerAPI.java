package com.buildfor2030.api.PartnerAPIs;

import com.buildfor2030.api.common.BaseEntityB;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "apis")
public class PartnerAPI extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

    private String websiteUrl;

    private String description;

    @ManyToMany
    @JoinTable(name = "api_category",
            joinColumns = {@JoinColumn(name = "apiId")},
            inverseJoinColumns = {@JoinColumn(name = "categoryId")})
    private Set<Category> categories = new HashSet<>();

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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public List<String> getCategoryNameList() {
        List<String> categoryNameList = new ArrayList<>();
        for (Category category : categories) {
            categoryNameList.add(category.getName());
        }
        return categoryNameList;
    }

}

