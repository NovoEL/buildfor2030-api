package com.buildfor2030.api.SolutionIdeas.repository;

import com.buildfor2030.api.SolutionIdeas.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long> {
    Stack findBySlug(String slug);
}
