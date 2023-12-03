package com.buildfor2030.api.BigIdeas.dto;

public class AnswerDTO {

    private Long bigIdeaId;

    private Long questionId;

    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
