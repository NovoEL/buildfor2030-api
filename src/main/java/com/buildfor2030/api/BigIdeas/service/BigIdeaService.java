package com.buildfor2030.api.BigIdeas.service;

import com.buildfor2030.api.BigIdeas.model.BigIdea;
import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
import com.buildfor2030.api.BigIdeas.vo.QuestionVO;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;

import java.util.List;

public interface BigIdeaService {

    List<BigIdeaVO> retrieveAllBigIdeas();

    BigIdeaVO retrieveBigIdea(String slug);

    List<BuilderVO> retrieveFollowers(String slug);

    List<QuestionVO> retrieveQuestions(String slug);

    List<SolutionIdeaVO> retrieveSolutionIdeas(String slug);

    List<BigIdea> retrieveBigIdeasBySlugs(List<String> slugs);

    void follow(String slug);

}
