package com.vadim.newsservice.service;

import com.vadim.newsservice.model.criteria.CommentCriteria;
import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CommentService {

    CommentResponseDto getById(UUID id);

    PageResponse<CommentResponseDto> getAll(Pageable pageable);
    PageResponse<CommentResponseDto> getAllByCriteria(Pageable pageable, CommentCriteria criteria);

    CommentResponseDto save(CommentRequestDto requestDto, String token);

    CommentResponseDto update(UUID id, CommentRequestDto requestDto, String token);

    void deleteById(UUID id, String token);
}
