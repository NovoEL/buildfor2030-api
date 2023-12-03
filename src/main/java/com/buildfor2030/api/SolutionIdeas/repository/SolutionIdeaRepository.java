package com.buildfor2030.api.SolutionIdeas.repository;

import com.buildfor2030.api.SolutionIdeas.model.SolutionIdea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionIdeaRepository extends JpaRepository<SolutionIdea, Long> {
}
