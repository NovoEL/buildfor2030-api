package com.buildfor2030.api.Builders.repository;

import com.buildfor2030.api.Builders.model.Comment;
import com.buildfor2030.api.Builders.model.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByAuthor(Builder author);

}
