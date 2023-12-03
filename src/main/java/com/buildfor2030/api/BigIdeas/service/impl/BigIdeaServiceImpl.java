package com.buildfor2030.api.BigIdeas.service.impl;

import com.buildfor2030.api.BigIdeas.model.BigIdea;
import com.buildfor2030.api.BigIdeas.model.BigIdeaFollow;
import com.buildfor2030.api.BigIdeas.repository.BigIdeaFollowRepository;
import com.buildfor2030.api.BigIdeas.repository.BigIdeaRepository;
import com.buildfor2030.api.BigIdeas.service.BigIdeaService;
import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
import com.buildfor2030.api.BigIdeas.vo.QuestionVO;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.service.BuilderService;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;
import com.buildfor2030.api.common.exception.BigIdeaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BigIdeaServiceImpl implements BigIdeaService {

    @Autowired
    private BigIdeaRepository bigIdeaRepository;

    @Autowired
    private BigIdeaFollowRepository followRepository;

    @Autowired
    private BuilderService builderService;

    public List<BigIdeaVO> retrieveAllBigIdeas() {
        return convertToBigIdeaVOs(bigIdeaRepository.findAll());
    }

    public BigIdeaVO retrieveBigIdea(String slug) {
        BigIdea bigIdea = Optional.ofNullable(bigIdeaRepository.findBySlug(slug)).orElseThrow(BigIdeaNotFoundException::new);
        return new BigIdeaVO(bigIdea);
    }
    
    public List<BuilderVO> retrieveFollowers(String slug) {
        BigIdea bigIdea = bigIdeaRepository.findBySlug(slug);
        return bigIdea.getFollowerList();
    }

    public List<QuestionVO> retrieveQuestions(String slug) {
        BigIdea bigIdea = bigIdeaRepository.findBySlug(slug);
        return bigIdea.getQuestionList();
    }

    public List<SolutionIdeaVO> retrieveSolutionIdeas(String slug) {
        BigIdea bigIdea = bigIdeaRepository.findBySlug(slug);
        return bigIdea.getSolutionIdeaList();
    }
    public List<BigIdea> retrieveBigIdeasBySlugs(List<String> slugs) {
        List<BigIdea> bigIdeas = new ArrayList<>();
        for (String slug : slugs) {
            BigIdea bigIdea = Optional.ofNullable(bigIdeaRepository.findBySlug(slug)).orElseThrow(BigIdeaNotFoundException::new);
            bigIdeas.add(bigIdea);
        }
        return bigIdeas;
    }

    public void follow(String slug) {
        BigIdea bigIdea = Optional.ofNullable(bigIdeaRepository.findBySlug(slug)).orElseThrow(BigIdeaNotFoundException::new);
        Builder builder = builderService.getCurrentBuilder();
        Optional<BigIdeaFollow> followOptional = Optional.ofNullable(followRepository.findFirstByBigIdeaAndBuilder(bigIdea, builder));
        if (followOptional.isEmpty()) {
            BigIdeaFollow follow = new BigIdeaFollow(bigIdea, builder);
            follow.setCreatedAt(new Date());
            followRepository.save(follow);
            bigIdea.addFollower(follow);
            builder.addBigIdeaFollowing(follow);
            return;
        }
        BigIdeaFollow follow = followOptional.get();
        bigIdea.removeFollower(follow);
        builder.removeBigIdeaFollowing(follow);
        followRepository.delete(follow);
    }

    private List<BigIdeaVO> convertToBigIdeaVOs(List<BigIdea> bigIdeas) {
        List<BigIdeaVO> bigIdeaVOs = new ArrayList<>();
        for (BigIdea bigIdea : bigIdeas) {
            bigIdeaVOs.add(new BigIdeaVO(bigIdea));
        }
        return bigIdeaVOs;
    }

}
