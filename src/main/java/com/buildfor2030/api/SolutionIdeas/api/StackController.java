package com.buildfor2030.api.SolutionIdeas.api;

import com.buildfor2030.api.SolutionIdeas.model.Stack;
import com.buildfor2030.api.SolutionIdeas.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stacks")
public class StackController {

    @Autowired
    private StackService stackService;

    @GetMapping
    public ResponseEntity<List<Stack>> getAllStacks(){
        List<Stack> stacks = stackService.retrieveAllStacks();
        return new ResponseEntity<>(stacks, HttpStatus.OK);
    }

}
