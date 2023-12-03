package com.buildfor2030.api.SolutionIdeas.service;

import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.SolutionIdeas.dto.SolutionIdeaDTO;
import com.buildfor2030.api.SolutionIdeas.dto.UpdateDTO;
import com.buildfor2030.api.SolutionIdeas.model.Update;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;

import java.util.List;

public interface SolutionIdeaService {

    SolutionIdeaVO createIdea(SolutionIdeaDTO dto);

    Update createUpdate(UpdateDTO dto);

    void support(Long id);

    List<SolutionIdeaVO> retrieveAllIdeas();

    SolutionIdeaVO retrieveIdea(Long id);

    List<Update> retrieveUpdates(Long id);

    List<BuilderVO> retrieveSupporters(Long id);

}
