package com.buildfor2030.api.SolutionIdeas.model;

import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;
import com.buildfor2030.api.common.BaseEntityC;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "supports")
public class Support extends BaseEntityC {

    @ManyToOne
    @JoinColumn(name = "ideaId")
    private SolutionIdea idea;

    @ManyToOne
    @JoinColumn(name = "builderId")
    private Builder builder;

    public Support(SolutionIdea idea, Builder builder) {
        this.idea = idea;
        this.builder = builder;
    }

    public Support() {
    }

    public SolutionIdea getIdea() {
        return idea;
    }

    public void setIdea(SolutionIdea idea) {
        this.idea = idea;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public SolutionIdeaVO getIdeaVO() {
        return new SolutionIdeaVO(idea);
    }

    public BuilderVO getBuilderVO() {
        return new BuilderVO(builder);
    }
}

