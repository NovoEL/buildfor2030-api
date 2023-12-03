package com.buildfor2030.api.BigIdeas.repository;

import com.buildfor2030.api.BigIdeas.model.SDG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SDGRepository extends JpaRepository<SDG, Long> {
}
