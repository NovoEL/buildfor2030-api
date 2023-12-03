package com.buildfor2030.api.BigIdeas.model;

import com.buildfor2030.api.BigIdeas.vo.QuestionVO;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.SolutionIdeas.model.SolutionIdea;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;
import com.buildfor2030.api.common.BaseEntityB;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "big_ideas")
public class BigIdea extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

    private String imageUrl;

    private String partners;

    private String essentialQuestions;

    //SDG: SUSTAINABLE DEVELOPMENT GOAL
    @ManyToMany
    @JoinTable(name = "big_ideas_sdgs",
            joinColumns = {@JoinColumn(name = "bigIdeaId")},
            inverseJoinColumns = {@JoinColumn(name = "sdgId")})
    private Set<SDG> sdgs = new HashSet<>();

    @OneToMany(mappedBy = "bigIdea")
    private List<BigIdeaFollow> followers = new ArrayList<>();

    @OneToMany(mappedBy = "bigIdea")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "bigIdea")
    private List<SolutionIdea> solutionIdeas = new ArrayList<>();

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

    public String getPartners() {
        return partners;
    }

    public void setPartners(String partners) {
        this.partners = partners;
    }

    public String getEssentialQuestions() {
        return essentialQuestions;
    }

    public void setEssentialQuestions(String essentialQuestions) {
        this.essentialQuestions = essentialQuestions;
    }

    public Set<SDG> getSdgs() {
        return sdgs;
    }

    public void setSdgs(Set<SDG> sdgs) {
        this.sdgs = sdgs;
    }

    public List<BigIdeaFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<BigIdeaFollow> followers) {
        this.followers = followers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<SolutionIdea> getSolutionIdeas() {
        return solutionIdeas;
    }

    public void setSolutionIdeas(List<SolutionIdea> solutionIdeas) {
        this.solutionIdeas = solutionIdeas;
    }

    public void addFollower(BigIdeaFollow follow) {
        followers.add(follow);
        follow.setBigIdea(this);
    }
    public void removeFollower(BigIdeaFollow follow)  {
        followers.remove(follow);
    }

    public Integer getFollowersCount() {
        return followers.size();
    }

    public List<BuilderVO> getFollowerList() {
        List<BuilderVO> followerList = new ArrayList<>();
        for (BigIdeaFollow follow : followers) {
            followerList.add(follow.getBuilderVO());
        }
        return followerList;
    }
    public void addQuestion(Question question) {
        questions.add(question);
        question.setBigIdea(this);
    }
    public void removeQuestion(Question question)  {
        questions.remove(question);
    }

    public Integer getQuestionsCount() {
        return questions.size();
    }

    public List<QuestionVO> getQuestionList() {
        List<QuestionVO> questionList = new ArrayList<>();
        for (Question question : questions) {
            questionList.add(new QuestionVO(question));
        }
        return questionList;
    }

    public void addSolutionIdea(SolutionIdea idea) {
        solutionIdeas.add(idea);
        idea.setBigIdea(this);
    }
    public void removeSolutionIdea(SolutionIdea idea)  {
        solutionIdeas.remove(idea);
    }

    public Integer getSolutionIdeasCount() {
        return solutionIdeas.size();
    }

    public List<SolutionIdeaVO> getSolutionIdeaList() {
        List<SolutionIdeaVO> ideaList = new ArrayList<>();
        for (SolutionIdea idea : solutionIdeas) {
            ideaList.add(new SolutionIdeaVO(idea));
        }
        return ideaList;
    }

}

