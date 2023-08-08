package com.vadim.newsservice.service;

import com.vadim.newsservice.model.criteria.CommentCriteria;
import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponseDto;
import com.vadim.newsservice.model.entity.Comment;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CommentService {

    CommentResponseDto getById(UUID id);

    PageResponseDto<Comment> getAll(Pageable pageable);

    PageResponseDto<CommentResponseDto> findAllByCriteria(CommentCriteria searchCriteria, Pageable pageable);

    CommentResponseDto save(CommentRequestDto requestDto);

    CommentResponseDto update(CommentRequestDto requestDto);

    void deleteById(UUID id);
}
