package com.buildfor2030.api.BigIdeas.vo;

import com.buildfor2030.api.BigIdeas.model.Answer;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.Builders.vo.CommentVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswerVO {

    private Long id;

    private Long bigIdeaId;

    private Long questionId;

    private BuilderVO author;

    private String content;

    private Date createdAt;

    private Integer commentsCount;

    private List<CommentVO> comments = new ArrayList<>();

    public AnswerVO(Answer answer) {
        BeanUtils.copyProperties(answer, this);
        this.author = answer.getAuthorVO();
        this.commentsCount = answer.getCommentsCount();
        this.comments = answer.getCommentList();
    }

    public AnswerVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBigIdeaId() {
        return bigIdeaId;
    }

    public void setBigIdeaId(Long bigIdeaId) {
        this.bigIdeaId = bigIdeaId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public BuilderVO getAuthor() {
        return author;
    }

    public void setAuthor(BuilderVO author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
    }
}
