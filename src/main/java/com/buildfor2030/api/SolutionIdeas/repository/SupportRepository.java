package com.buildfor2030.api.SolutionIdeas.repository;

import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.SolutionIdeas.model.SolutionIdea;
import com.buildfor2030.api.SolutionIdeas.model.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long> {
    Support findFirstByIdeaAndBuilder(SolutionIdea idea, Builder builder);
}
