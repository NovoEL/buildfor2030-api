package com.buildfor2030.api.BigIdeas.repository;

import com.buildfor2030.api.BigIdeas.model.BigIdea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BigIdeaRepository extends JpaRepository<BigIdea, Long> {
    BigIdea findBySlug(String slug);
}