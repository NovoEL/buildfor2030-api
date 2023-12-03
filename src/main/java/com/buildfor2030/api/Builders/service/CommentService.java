package com.buildfor2030.api.Builders.service;

import com.buildfor2030.api.Builders.dto.CommentDTO;
import com.buildfor2030.api.Builders.model.Comment;
import com.buildfor2030.api.Builders.vo.CommentVO;

import java.util.List;

public interface CommentService {

    CommentVO createComment(CommentDTO dto);

    List<CommentVO> retrieveCommentsByAuthor(String username);

    Comment retrieveComment(Long id);

    CommentVO updateComment(Long id, CommentDTO dto);

    void deleteComment(Long id);

}
