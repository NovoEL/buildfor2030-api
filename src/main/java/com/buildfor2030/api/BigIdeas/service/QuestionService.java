package com.buildfor2030.api.BigIdeas.service;

import com.buildfor2030.api.BigIdeas.dto.AnswerDTO;
import com.buildfor2030.api.BigIdeas.dto.QuestionDTO;
import com.buildfor2030.api.BigIdeas.vo.AnswerVO;
import com.buildfor2030.api.BigIdeas.vo.QuestionVO;

public interface QuestionService {

    QuestionVO createQuestion(QuestionDTO dto);

    AnswerVO createAnswer(AnswerDTO dto);

    QuestionVO retrieveQuestion(Long id);

}
