package com.buildfor2030.api.BigIdeas.repository;

import com.buildfor2030.api.BigIdeas.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
