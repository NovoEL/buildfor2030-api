package com.buildfor2030.api.SolutionIdeas.service.impl;

import com.buildfor2030.api.SolutionIdeas.model.Stack;
import com.buildfor2030.api.SolutionIdeas.repository.StackRepository;
import com.buildfor2030.api.SolutionIdeas.service.StackService;
import com.buildfor2030.api.common.exception.StackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StackServiceImpl implements StackService {

    @Autowired
    private StackRepository stackRepository;

    public List<Stack> retrieveAllStacks() {
        return stackRepository.findAll();
    }

    public List<Stack> retrieveStacksBySlugs(List<String> slugs) {
        List<Stack> stacks = new ArrayList<>();
        for (String slug : slugs) {
            Stack stack = Optional.ofNullable(stackRepository.findBySlug(slug)).orElseThrow(StackNotFoundException::new);
            stacks.add(stack);
        }
        return stacks;
    }

}
