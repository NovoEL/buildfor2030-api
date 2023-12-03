package com.buildfor2030.api.BigIdeas.api;

import com.buildfor2030.api.BigIdeas.dto.AnswerDTO;
import com.buildfor2030.api.BigIdeas.dto.QuestionDTO;
import com.buildfor2030.api.BigIdeas.service.*;
import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
import com.buildfor2030.api.BigIdeas.vo.QuestionVO;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.SolutionIdeas.dto.SolutionIdeaDTO;
import com.buildfor2030.api.SolutionIdeas.service.SolutionIdeaService;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/big-ideas")
public class BigIdeaController {

    @Autowired
    private BigIdeaService bigIdeaService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SolutionIdeaService solutionIdeaService;

    @PostMapping("/{slug}/followers")
    public ResponseEntity<Void> follow(@PathVariable String slug) {
        bigIdeaService.follow(slug);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{slug}/questions")
    public ResponseEntity<Void> newQuestion(@PathVariable String slug, @RequestBody QuestionDTO request) {
        //TODO check permission
        BigIdeaVO bigIdea = bigIdeaService.retrieveBigIdea(slug);
        request.setBigIdeaId(bigIdea.getId());
        questionService.createQuestion(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{slug}/questions/{id}/answers")
    public ResponseEntity<Void> newAnswer(@PathVariable String slug, @PathVariable Long id, @RequestBody AnswerDTO request) {
        //TODO check permission
        BigIdeaVO bigIdea = bigIdeaService.retrieveBigIdea(slug);
        request.setBigIdeaId(bigIdea.getId());
        QuestionVO question = questionService.retrieveQuestion(id);
        request.setQuestionId(question.getId());
        questionService.createAnswer(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{slug}/solution-ideas")
    public ResponseEntity<Void> newSolutionIdea(@PathVariable String slug, @RequestBody SolutionIdeaDTO request) {
        BigIdeaVO bigIdea = bigIdeaService.retrieveBigIdea(slug);
        request.setBigIdeaId(bigIdea.getId());
        solutionIdeaService.createIdea(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<BigIdeaVO>> getAllBigIdeas() {
        List<BigIdeaVO> bigIdeas = bigIdeaService.retrieveAllBigIdeas();
        return new ResponseEntity<>(bigIdeas, HttpStatus.OK);
    }
    @GetMapping("/{slug}")
    public ResponseEntity<BigIdeaVO> getBigIdea(@PathVariable String slug) {
        BigIdeaVO bigIdea = bigIdeaService.retrieveBigIdea(slug);
        return new ResponseEntity<>(bigIdea, HttpStatus.OK);
    }

    @GetMapping("/{slug}/followers")
    public ResponseEntity<List<BuilderVO>> getFollowers(@PathVariable String slug) {
        List<BuilderVO> followers = bigIdeaService.retrieveFollowers(slug);
        return new ResponseEntity<>(followers, HttpStatus.OK);
    }

    @GetMapping("/{slug}/questions")
    public ResponseEntity<List<QuestionVO>> getQuestions(@PathVariable String slug) {
        List<QuestionVO> questions = bigIdeaService.retrieveQuestions(slug);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{slug}/solution-ideas")
    public ResponseEntity<List<SolutionIdeaVO>> getSolutionIdeas(@PathVariable String slug) {
        List<SolutionIdeaVO> solutionIdeas = bigIdeaService.retrieveSolutionIdeas(slug);
        return new ResponseEntity<>(solutionIdeas, HttpStatus.OK);
    }
    
}
