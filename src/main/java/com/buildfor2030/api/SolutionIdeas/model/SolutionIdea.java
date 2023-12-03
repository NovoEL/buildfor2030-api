package com.buildfor2030.api.SolutionIdeas.model;

import com.buildfor2030.api.BigIdeas.model.BigIdea;
import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.model.Comment;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.Builders.vo.CommentVO;
import com.buildfor2030.api.PartnerAPIs.PartnerAPI;
import com.buildfor2030.api.PartnerAPIs.PartnerAPIVO;
import com.buildfor2030.api.common.BaseEntityB;
import com.buildfor2030.api.common.enumeration.CommentableType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "solution_ideas")
public class SolutionIdea extends BaseEntityB {
    
    @ManyToOne
    @JoinColumn(name = "bigIdeaId")
    private BigIdea bigIdea;

    @ManyToOne
    @JoinColumn(name = "builderId")
    private Builder builder;
    
    private String name;

    private String imageUrl;

    private String demoUrl;

    private String repoUrl;

    private String description;

    @ManyToMany
    @JoinTable(name = "ideas_apis",
            joinColumns = {@JoinColumn(name = "ideaId")},
            inverseJoinColumns = {@JoinColumn(name = "apiId")})
    private Set<PartnerAPI> apis = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "ideas_stacks",
            joinColumns = {@JoinColumn(name = "ideaId")},
            inverseJoinColumns = {@JoinColumn(name = "stackId")})
    private Set<Stack> stacks = new HashSet<>();

    private Boolean isFeatured;

    @OneToMany
    @JoinColumn(name = "ideaId")
    private List<Update> updates = new ArrayList<>();

    @OneToMany(mappedBy = "idea")
    private List<Support> supporters = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "commentableId")
    private List<Comment> comments = new ArrayList<>();

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

    public Set<PartnerAPI> getAPIs() {
        return apis;
    }

    public void setAPIs(Set<PartnerAPI> apis) {
        this.apis = apis;
    }

    public Set<Stack> getStacks() {
        return stacks;
    }

    public void setStacks(Set<Stack> stacks) {
        this.stacks = stacks;
    }

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public List<Update> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Update> updates) {
        this.updates = updates;
    }

    public List<Support> getSupporters() {
        return supporters;
    }

    public void setSupporters(List<Support> supporters) {
        this.supporters = supporters;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public BigIdeaVO getBigIdeaVO() {
        return new BigIdeaVO(bigIdea);
    }

    public BuilderVO getBuilderVO() {
        return new BuilderVO(builder);
    }

    public List<PartnerAPIVO> getAPIList() {
        List<PartnerAPIVO> apiList = new ArrayList<>();
        for (PartnerAPI api : apis) {
            apiList.add(new PartnerAPIVO(api));
        }
        return apiList;
    }

    public void addUpdate(Update update) {
        updates.add(update);
        update.setIdeaId(this.getId());
    }

    public void removeUpdate(Update update) {
        updates.remove(update);
    }

    public Integer getUpdatesCount() {
        return updates.size();
    }

    public void addSupporter(Support support) {
        supporters.add(support);
        support.setIdea(this);
    }

    public void removeSupporter(Support support) {
        supporters.remove(support);
    }

    public Integer getSupportersCount() {
        return supporters.size();
    }

    public List<BuilderVO> getSupporterList() {
        List<BuilderVO> supporterList = new ArrayList<>();
        for (Support support : supporters) {
            supporterList.add(support.getBuilderVO());
        }
        return supporterList;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommentableType(CommentableType.SOLUTION_IDEA);
        comment.setCommentableId(this.getId());
    }
    public void removeComment(Comment comment)  {
        comments.remove(comment);
    }

    public Integer getCommentsCount() {
        return comments.size();
    }

    public List<CommentVO> getCommentList() {
        List<CommentVO> commentList = new ArrayList<>();
        for (Comment comment : comments) {
            commentList.add(new CommentVO(comment));
        }
        return commentList;
    }

}
