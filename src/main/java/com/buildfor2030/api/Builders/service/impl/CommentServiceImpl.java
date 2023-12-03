package com.buildfor2030.api.Builders.service.impl;

import com.buildfor2030.api.BigIdeas.model.Answer;
import com.buildfor2030.api.BigIdeas.model.Question;
import com.buildfor2030.api.BigIdeas.repository.AnswerRepository;
import com.buildfor2030.api.BigIdeas.repository.QuestionRepository;
import com.buildfor2030.api.Builders.dto.CommentDTO;
import com.buildfor2030.api.Builders.model.Comment;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.repository.CommentRepository;
import com.buildfor2030.api.Builders.service.CommentService;
import com.buildfor2030.api.Builders.service.BuilderService;
import com.buildfor2030.api.Builders.vo.CommentVO;
import com.buildfor2030.api.SolutionIdeas.model.SolutionIdea;
import com.buildfor2030.api.SolutionIdeas.repository.SolutionIdeaRepository;
import com.buildfor2030.api.common.exception.AnswerNotFoundException;
import com.buildfor2030.api.common.exception.CommentNotFoundException;
import com.buildfor2030.api.common.exception.QuestionNotFoundException;
import com.buildfor2030.api.common.exception.SolutionIdeaNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private SolutionIdeaRepository solutionIdeaRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private BuilderService builderService;

    public CommentVO createComment(CommentDTO dto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(dto, comment);
        comment.setAuthor(builderService.getCurrentBuilder());
        comment.setCreatedAt(new Date());
        commentRepository.save(comment);
        switch (comment.getCommentableType()) {
            case SOLUTION_IDEA:
                SolutionIdea SolutionIdea = solutionIdeaRepository.findById(comment.getCommentableId()).orElseThrow(SolutionIdeaNotFoundException::new);
                SolutionIdea.addComment(comment);
                break;
            case QUESTION:
                Question question = questionRepository.findById(comment.getCommentableId()).orElseThrow(QuestionNotFoundException::new);
                question.addComment(comment);
                break;
            case ANSWER:
                Answer answer = answerRepository.findById(comment.getCommentableId()).orElseThrow(AnswerNotFoundException::new);
                answer.addComment(comment);
                break;
        }
        return new CommentVO(comment);
    }

    public List<CommentVO> retrieveCommentsByAuthor(String username) {
        Builder author = builderService.retrieveBuilder(username);
        List<Comment> comments = commentRepository.findAllByAuthor(author);
        return convertToCommentVOs(comments);
    }

    public Comment retrieveComment(Long id) {
        return commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
    }

    public CommentVO updateComment(Long id, CommentDTO dto) {
        Comment comment = retrieveComment(id);
        BeanUtils.copyProperties(dto, comment);
        commentRepository.save(comment);
        return new CommentVO(comment);
    }
    public void deleteComment(Long id) {
        Comment comment = retrieveComment(id);
        switch (comment.getCommentableType()) {
            case SOLUTION_IDEA:
                SolutionIdea SolutionIdea = solutionIdeaRepository.findById(comment.getCommentableId()).orElseThrow(SolutionIdeaNotFoundException::new);
                SolutionIdea.removeComment(comment);
                break;
            case QUESTION:
                Question question = questionRepository.findById(comment.getCommentableId()).orElseThrow(QuestionNotFoundException::new);
                question.removeComment(comment);
                break;
            case ANSWER:
                Answer answer = answerRepository.findById(comment.getCommentableId()).orElseThrow(AnswerNotFoundException::new);
                answer.removeComment(comment);
                break;
        }
        commentRepository.delete(comment);
    }

    private List<CommentVO> convertToCommentVOs(List<Comment> comments) {
        List<CommentVO> commentVOs = new ArrayList<>();
        for (Comment comment : comments) {
            commentVOs.add(new CommentVO(comment));
        }
        return commentVOs;
    }

}
