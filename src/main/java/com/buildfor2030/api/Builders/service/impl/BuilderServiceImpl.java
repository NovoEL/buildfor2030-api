package com.buildfor2030.api.Builders.service.impl;

import com.buildfor2030.api.Auth.AuthService;
import com.buildfor2030.api.Builders.dto.BuilderProfileDTO;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.model.Follow;
import com.buildfor2030.api.Builders.repository.BuilderRepository;
import com.buildfor2030.api.Builders.repository.FollowRepository;
import com.buildfor2030.api.Builders.service.BuilderService;
import com.buildfor2030.api.Builders.vo.BuilderProfileVO;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.common.exception.BuilderNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BuilderServiceImpl implements BuilderService {

    @Autowired
    private BuilderRepository builderRepository;

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private AuthService authService;

    public Builder retrieveBuilder(String username) {
        Builder builder = Optional.ofNullable(builderRepository.findByUsername(username)).orElseThrow(BuilderNotFoundException::new);
        return builder;
    }

    public List<Builder> retrieveBuildersByUsernames(List<String> usernames) {
        List<Builder> builders = new ArrayList<>();
        for (String username : usernames) {
            Builder builder = retrieveBuilder(username);
            builders.add(builder);
        }
        return builders;
    }

    public List<BuilderVO> retrieveAllBuilders() {
        return convertToBuilderVOs(builderRepository.findAll());
    }

    public Builder getCurrentBuilder() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if (username == null) throw new RuntimeException("Please Sign In First");
        return retrieveBuilder(username);
    }
    public BuilderProfileVO retrieveBuilderProfile(String username) {
        Builder builder = retrieveBuilder(username);
        return new BuilderProfileVO(builder);
    }

    public BuilderProfileVO updateBuilderProfile(BuilderProfileDTO dto) {
        Builder builder = getCurrentBuilder();
        BeanUtils.copyProperties(dto, builder);
        builderRepository.save(builder);
        return new BuilderProfileVO(builder);
    }

    public void follow(String username) {
        Builder following = retrieveBuilder(username);
        Builder follower = getCurrentBuilder();
        Optional<Follow> followOptional = Optional.ofNullable(followRepository.findFirstByFollowingAndFollower(following, follower));
        if (followOptional.isEmpty()) {
            Follow follow = new Follow(following, follower);
            follow.setCreatedAt(new Date());
            followRepository.save(follow);
            following.addFollower(follow);
            follower.addFollowing(follow);
            return;
        }
        Follow follow = followOptional.get();
        following.removeFollower(follow);
        follower.removeFollowing(follow);
        followRepository.delete(follow);
    }

    private List<BuilderVO> convertToBuilderVOs(List<Builder> builders) {
        List<BuilderVO> builderVOs = new ArrayList<>();
        for (Builder builder : builders) {
            builderVOs.add(new BuilderVO(builder));
        }
        return builderVOs;
    }

}
