package com.buildfor2030.api.BigIdeas.model;

import com.buildfor2030.api.common.BaseEntityB;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//SDG: SUSTAINABLE DEVELOPMENT GOAL

@Entity
@Table(name = "sdgs")
public class SDG extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

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

}

