package com.buildfor2030.api.BigIdeas.service.impl;

import com.buildfor2030.api.BigIdeas.dto.AnswerDTO;
import com.buildfor2030.api.BigIdeas.dto.QuestionDTO;
import com.buildfor2030.api.BigIdeas.model.Answer;
import com.buildfor2030.api.BigIdeas.model.BigIdea;
import com.buildfor2030.api.BigIdeas.model.Question;
import com.buildfor2030.api.BigIdeas.repository.AnswerRepository;
import com.buildfor2030.api.BigIdeas.repository.BigIdeaRepository;
import com.buildfor2030.api.BigIdeas.repository.QuestionRepository;
import com.buildfor2030.api.BigIdeas.service.QuestionService;
import com.buildfor2030.api.BigIdeas.vo.AnswerVO;
import com.buildfor2030.api.BigIdeas.vo.QuestionVO;
import com.buildfor2030.api.Builders.service.BuilderService;
import com.buildfor2030.api.common.exception.BigIdeaNotFoundException;
import com.buildfor2030.api.common.exception.QuestionNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private BigIdeaRepository bigIdeaRepository;

    @Autowired
    private BuilderService builderService;

    public QuestionVO createQuestion(QuestionDTO dto) {
        BigIdea bigIdea = bigIdeaRepository.findById(dto.getBigIdeaId()).orElseThrow(BigIdeaNotFoundException::new);
        Question question = new Question();
        BeanUtils.copyProperties(dto, this);
        question.setAuthor(builderService.getCurrentBuilder());
        question.setCreatedAt(new Date());
        questionRepository.save(question);
        bigIdea.addQuestion(question);
        bigIdeaRepository.save(bigIdea);
        return new QuestionVO(question);
    }

    public AnswerVO createAnswer(AnswerDTO dto) {
        Question question = questionRepository.findById(dto.getQuestionId()).orElseThrow(QuestionNotFoundException::new);
        Answer answer = new Answer();
        BeanUtils.copyProperties(dto, this);
        answer.setAuthor(builderService.getCurrentBuilder());
        answer.setCreatedAt(new Date());
        answerRepository.save(answer);
        question.addAnswer(answer);
        questionRepository.save(question);
        return new AnswerVO(answer);
    }

    public QuestionVO retrieveQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
        return new QuestionVO(question);
    }
    private List<QuestionVO> convertToQuestionVOs(List<Question> questions) {
        List<QuestionVO> questionVOs = new ArrayList<>();
        for (Question question : questions) {
            questionVOs.add(new QuestionVO(question));
        }
        return questionVOs;
    }

}
