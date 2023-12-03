package com.buildfor2030.api.PartnerAPIs;

import com.buildfor2030.api.common.BaseEntityB;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

    private String imageUrl;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<PartnerAPI> apis = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PartnerAPI> getAPIs() {
        return apis;
    }

    public void setAPIs(Set<PartnerAPI> apis) {
        this.apis = apis;
    }

    public Integer getAPIsCount() {
        return apis.size();
    }

    public List<PartnerAPIVO> getAPIList() {
        List<PartnerAPIVO> apiList = new ArrayList<>();
        for (PartnerAPI api : apis) {
            apiList.add(new PartnerAPIVO(api));
        }
        return apiList;
    }
}
