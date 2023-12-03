package com.buildfor2030.api.BigIdeas.model;

import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.model.Comment;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.Builders.vo.CommentVO;
import com.buildfor2030.api.common.BaseEntityB;
import com.buildfor2030.api.common.enumeration.CommentableType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answer extends BaseEntityB {

    private Long bigIdeaId;

    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Builder author;

    private String content;

    @OneToMany
    @JoinColumn(name = "commentableId")
    private List<Comment> comments = new ArrayList<>();

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

    public Builder getAuthor() {
        return author;
    }

    public void setAuthor(Builder author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public BuilderVO getAuthorVO() {
        return new BuilderVO(author);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommentableType(CommentableType.ANSWER);
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
