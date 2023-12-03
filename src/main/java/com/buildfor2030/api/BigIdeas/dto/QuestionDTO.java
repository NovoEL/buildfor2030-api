package com.buildfor2030.api.BigIdeas.dto;

public class QuestionDTO {

    private Long bigIdeaId;

    private String title;

    private String body;

    public Long getBigIdeaId() {
        return bigIdeaId;
    }

    public void setBigIdeaId(Long bigIdeaId) {
        this.bigIdeaId = bigIdeaId;
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
}
