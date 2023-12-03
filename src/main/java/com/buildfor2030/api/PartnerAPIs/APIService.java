package com.buildfor2030.api.PartnerAPIs;

import java.util.List;

public interface APIService {

    List<PartnerAPIVO> retrieveAllAPIs();

    List<PartnerAPIVO> retrieveAPIsByCategory(String slug);

    PartnerAPI retrieveAPI(String slug);

    List<PartnerAPI> retrieveAPIsBySlugs(List<String> slugs);

}
