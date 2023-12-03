package com.buildfor2030.api.BigIdeas.model;

import com.buildfor2030.api.BigIdeas.vo.AnswerVO;
import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
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
@Table(name = "questions")
public class Question extends BaseEntityB {

    @ManyToOne
    @JoinColumn(name = "bigIdeaId")
    private BigIdea bigIdea;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Builder author;

    private String title;

    private String body;

    @OneToMany
    @JoinColumn(name = "commentableId")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "questionId")
    private List<Answer> answers = new ArrayList<>();

    public BigIdea getBigIdea() {
        return bigIdea;
    }

    public void setBigIdea(BigIdea bigIdea) {
        this.bigIdea = bigIdea;
    }

    public Builder getAuthor() {
        return author;
    }

    public void setAuthor(Builder author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public BigIdeaVO getBigIdeaVO() {
        return new BigIdeaVO(bigIdea);
    }
    public BuilderVO getAuthorVO() {
        return new BuilderVO(author);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommentableType(CommentableType.QUESTION);
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
    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestionId(this.getId());
        answer.setBigIdeaId(bigIdea.getId());
    }

    public void removeAnswer(Answer answer)  {
        answers.remove(answer);
    }

    public Integer getAnswersCount() {
        return answers.size();
    }

    public List<AnswerVO> getAnswerList() {
        List<AnswerVO> answerList = new ArrayList<>();
        for (Answer answer : answers) {
            answerList.add(new AnswerVO(answer));
        }
        return answerList;
    }

}
