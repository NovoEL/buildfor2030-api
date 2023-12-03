package com.buildfor2030.api.SolutionIdeas.service;

import com.buildfor2030.api.SolutionIdeas.model.Stack;

import java.util.List;

public interface StackService {

    List<Stack> retrieveAllStacks();

    List<Stack> retrieveStacksBySlugs(List<String> slugs);

}
