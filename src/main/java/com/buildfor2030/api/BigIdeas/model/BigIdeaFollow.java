package com.buildfor2030.api.BigIdeas.model;

import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.common.BaseEntityC;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "big_idea_follows")
public class BigIdeaFollow extends BaseEntityC {

    @ManyToOne
    @JoinColumn(name = "bigIdeaId")
    private BigIdea bigIdea;

    @ManyToOne
    @JoinColumn(name = "builderId")
    private Builder builder;

    public BigIdeaFollow(BigIdea bigIdea, Builder builder) {
        this.bigIdea = bigIdea;
        this.builder = builder;
    }

    public BigIdeaFollow() {
    }

    public BigIdea getBigIdea() {
        return bigIdea;
    }

    public void setBigIdea(BigIdea bigIdea) {
        this.bigIdea = bigIdea;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public BigIdeaVO getBigIdeaVO() {
        return new BigIdeaVO(bigIdea);
    }

    public BuilderVO getBuilderVO() {
        return new BuilderVO(builder);
    }
}
