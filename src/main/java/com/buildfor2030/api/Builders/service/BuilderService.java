package com.buildfor2030.api.Builders.service;

import com.buildfor2030.api.Builders.dto.BuilderProfileDTO;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.vo.BuilderProfileVO;
import com.buildfor2030.api.Builders.vo.BuilderVO;

import java.util.List;

public interface BuilderService {

    List<BuilderVO> retrieveAllBuilders();

    Builder retrieveBuilder(String username);

    List<Builder> retrieveBuildersByUsernames(List<String> usernames);

    Builder getCurrentBuilder();

    BuilderProfileVO retrieveBuilderProfile(String username);

    BuilderProfileVO updateBuilderProfile(BuilderProfileDTO dto);

    void follow(String username);

}
