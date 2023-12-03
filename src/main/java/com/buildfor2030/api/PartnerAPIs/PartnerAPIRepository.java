package com.buildfor2030.api.PartnerAPIs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerAPIRepository extends JpaRepository<PartnerAPI, Long> {
    PartnerAPI findBySlug(String slug);

}
