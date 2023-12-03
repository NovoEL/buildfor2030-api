package com.buildfor2030.api.SolutionIdeas.repository;

import com.buildfor2030.api.SolutionIdeas.model.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateRepository extends JpaRepository<Update, Long> {
}
