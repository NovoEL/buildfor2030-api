package com.buildfor2030.api.SolutionIdeas.api;

import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.SolutionIdeas.dto.UpdateDTO;
import com.buildfor2030.api.SolutionIdeas.model.Update;
import com.buildfor2030.api.SolutionIdeas.service.SolutionIdeaService;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/solution-ideas")
public class SolutionIdeaController {

    @Autowired
    private SolutionIdeaService ideaService;

    @PostMapping("/{id}/updates")
    public ResponseEntity<Void> newUpdate(@PathVariable Long id, @RequestBody UpdateDTO request) {
        SolutionIdeaVO idea = ideaService.retrieveIdea(id);
        request.setIdeaId(id);
        ideaService.createUpdate(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/supporters")
    public ResponseEntity<Void> support(@PathVariable Long id) {
        ideaService.support(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SolutionIdeaVO>> getAllIdeas() {
        List<SolutionIdeaVO> solutionIdeaVOS = ideaService.retrieveAllIdeas();
        return new ResponseEntity<>(solutionIdeaVOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolutionIdeaVO> getIdea(@PathVariable Long id) {
        SolutionIdeaVO solutionIdeaVO = ideaService.retrieveIdea(id);
        return new ResponseEntity<>(solutionIdeaVO, HttpStatus.OK);
    }

    @GetMapping("/{id}/updates")
    public ResponseEntity<List<Update>> getUpdates(@PathVariable Long id) {
        List<Update> updates = ideaService.retrieveUpdates(id);
        return new ResponseEntity<>(updates, HttpStatus.OK);
    }

    @GetMapping("/{id}/supporters")
    public ResponseEntity<List<BuilderVO>> getSupporters(@PathVariable Long id) {
        List<BuilderVO> supporters = ideaService.retrieveSupporters(id);
        return new ResponseEntity<>(supporters, HttpStatus.OK);
    }

}
