package com.buildfor2030.api.BigIdeas.repository;

import com.buildfor2030.api.BigIdeas.model.BigIdea;
import com.buildfor2030.api.BigIdeas.model.BigIdeaFollow;
import com.buildfor2030.api.Builders.model.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BigIdeaFollowRepository extends JpaRepository<BigIdeaFollow, Long> {
    BigIdeaFollow findFirstByBigIdeaAndBuilder(BigIdea bigIdea, Builder builder);
}
