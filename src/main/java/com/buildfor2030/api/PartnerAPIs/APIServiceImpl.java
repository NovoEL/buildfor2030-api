package com.buildfor2030.api.PartnerAPIs;

import com.buildfor2030.api.common.exception.CategoryNotFoundException;
import com.buildfor2030.api.common.exception.PartnerAPINotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class APIServiceImpl implements APIService {

    @Autowired
    private PartnerAPIRepository partnerAPIRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<PartnerAPIVO> retrieveAllAPIs() {
        return convertToPartnerAPIVOs(partnerAPIRepository.findAll());
    }

    public List<PartnerAPIVO> retrieveAPIsByCategory(String slug) {
        Category category = Optional.ofNullable(categoryRepository.findBySlug(slug)).orElseThrow(CategoryNotFoundException::new);
        return List.copyOf(category.getAPIList());
    }

    public PartnerAPI retrieveAPI(String slug) {
        PartnerAPI api = Optional.ofNullable(partnerAPIRepository.findBySlug(slug)).orElseThrow(PartnerAPINotFoundException::new);
        return api;
    }

    public List<PartnerAPI> retrieveAPIsBySlugs(List<String> slugs) {
        List<PartnerAPI> apis = new ArrayList<>();
        for (String slug : slugs) {
            PartnerAPI api = Optional.ofNullable(partnerAPIRepository.findBySlug(slug)).orElseThrow(PartnerAPINotFoundException::new);
            apis.add(api);
        }
        return apis;
    }

    private List<PartnerAPIVO> convertToPartnerAPIVOs(List<PartnerAPI> apis) {
        List<PartnerAPIVO> apiVOs = new ArrayList<>();
        for (PartnerAPI api : apis) {
            apiVOs.add(new PartnerAPIVO(api));
        }
        return apiVOs;
    }

}
