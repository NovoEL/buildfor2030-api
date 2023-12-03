package com.buildfor2030.api.SolutionIdeas.service.impl;

import com.buildfor2030.api.BigIdeas.model.BigIdea;
import com.buildfor2030.api.BigIdeas.repository.BigIdeaRepository;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.service.BuilderService;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.PartnerAPIs.APIService;
import com.buildfor2030.api.PartnerAPIs.PartnerAPI;
import com.buildfor2030.api.SolutionIdeas.dto.SolutionIdeaDTO;
import com.buildfor2030.api.SolutionIdeas.dto.UpdateDTO;
import com.buildfor2030.api.SolutionIdeas.model.SolutionIdea;
import com.buildfor2030.api.SolutionIdeas.model.Stack;
import com.buildfor2030.api.SolutionIdeas.model.Support;
import com.buildfor2030.api.SolutionIdeas.model.Update;
import com.buildfor2030.api.SolutionIdeas.repository.SolutionIdeaRepository;
import com.buildfor2030.api.SolutionIdeas.repository.SupportRepository;
import com.buildfor2030.api.SolutionIdeas.repository.UpdateRepository;
import com.buildfor2030.api.SolutionIdeas.service.SolutionIdeaService;
import com.buildfor2030.api.SolutionIdeas.service.StackService;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;
import com.buildfor2030.api.common.exception.BigIdeaNotFoundException;
import com.buildfor2030.api.common.exception.SolutionIdeaNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class SolutionIdeaServiceImpl implements SolutionIdeaService {

    @Autowired
    private SolutionIdeaRepository solutionIdeaRepository;

    @Autowired
    private BigIdeaRepository bigIdeaRepository;

    @Autowired
    private UpdateRepository updateRepository;

    @Autowired
    private SupportRepository supportRepository;

    @Autowired
    private BuilderService builderService;

    @Autowired
    private APIService apiService;

    @Autowired
    private StackService stackService;

    public SolutionIdeaVO createIdea(SolutionIdeaDTO dto) {
        BigIdea bigIdea = bigIdeaRepository.findById(dto.getBigIdeaId()).orElseThrow(BigIdeaNotFoundException::new);
        Builder builder = builderService.getCurrentBuilder();
        SolutionIdea solutionIdea = new SolutionIdea();
        BeanUtils.copyProperties(dto, solutionIdea);
        solutionIdea.setBigIdea(bigIdea);
        solutionIdea.setBuilder(builder);
        List<PartnerAPI> apiList = apiService.retrieveAPIsBySlugs(dto.getAPISlugList());
        solutionIdea.setAPIs(Set.copyOf(apiList));
        List<Stack> stackList = stackService.retrieveStacksBySlugs(dto.getStackSlugList());
        solutionIdea.setStacks(Set.copyOf(stackList));
        solutionIdea.setCreatedAt(new Date());
        solutionIdeaRepository.save(solutionIdea);
        builder.addIdea(solutionIdea);
        bigIdea.addSolutionIdea(solutionIdea);
        return new SolutionIdeaVO(solutionIdea);
    }

    public Update createUpdate(UpdateDTO dto) {
        SolutionIdea idea = solutionIdeaRepository.findById(dto.getIdeaId()).orElseThrow(SolutionIdeaNotFoundException::new);
        Update update = new Update(dto);
        update.setCreatedAt(new Date());
        updateRepository.save(update);
        idea.addUpdate(update);
        return update;
    }

    public void support(Long id) {
        SolutionIdea idea = solutionIdeaRepository.findById(id).orElseThrow(SolutionIdeaNotFoundException::new);
        Builder builder = builderService.getCurrentBuilder();
        Optional<Support> supportOptional = Optional.ofNullable(supportRepository.findFirstByIdeaAndBuilder(idea, builder));
        if (supportOptional.isEmpty()) {
            Support support = new Support(idea, builder);
            supportRepository.save(support);
            idea.addSupporter(support);
            builder.addSupporting(support);
            return;
        }
        Support support = supportOptional.get();
        idea.removeSupporter(support);
        builder.removeSupporting(support);
        supportRepository.delete(support);
    }

    public List<SolutionIdeaVO> retrieveAllIdeas() {
        return convertToIdeaVOs(solutionIdeaRepository.findAll());
    }

    public SolutionIdeaVO retrieveIdea(Long id) {
        SolutionIdea idea = solutionIdeaRepository.findById(id).orElseThrow(SolutionIdeaNotFoundException::new);
        return new SolutionIdeaVO(idea);
    }

    public List<Update> retrieveUpdates(Long id) {
        SolutionIdea idea = solutionIdeaRepository.findById(id).orElseThrow(SolutionIdeaNotFoundException::new);
        return idea.getUpdates();
    }

    public List<BuilderVO> retrieveSupporters(Long id) {
        SolutionIdea idea = solutionIdeaRepository.findById(id).orElseThrow(SolutionIdeaNotFoundException::new);
        return idea.getSupporterList();
    }

    private List<SolutionIdeaVO> convertToIdeaVOs(List<SolutionIdea> ideas) {
        List<SolutionIdeaVO> ideaVOs = new ArrayList<>();
        for (SolutionIdea idea : ideas) {
            ideaVOs.add(new SolutionIdeaVO(idea));
        }
        return ideaVOs;
    }

}
