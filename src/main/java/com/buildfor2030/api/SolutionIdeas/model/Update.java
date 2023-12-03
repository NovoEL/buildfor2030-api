package com.buildfor2030.api.SolutionIdeas.model;

import com.buildfor2030.api.SolutionIdeas.dto.UpdateDTO;
import com.buildfor2030.api.common.BaseEntityB;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "updates")
public class Update extends BaseEntityB {

    private Long ideaId;

    private String title;

    private String imageUrl;

    private String body;

    public Update(UpdateDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

    public Update() {
    }

    public Long getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Long ideaId) {
        this.ideaId = ideaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
