package com.vadim.newsservice.service.impl;

import com.vadim.newsservice.model.criteria.CommentCriteria;
import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponseDto;
import com.vadim.newsservice.model.entity.Comment;
import com.vadim.newsservice.service.CommentService;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class CommentServiceImpl implements CommentService {
    @Override
    public CommentResponseDto getById(UUID id) {
        return null;
    }

    @Override
    public PageResponseDto<Comment> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public PageResponseDto<CommentResponseDto> findAllByCriteria(CommentCriteria searchCriteria, Pageable pageable) {
        return null;
    }

    @Override
    public CommentResponseDto save(CommentRequestDto requestDto) {
        return null;
    }

    @Override
    public CommentResponseDto update(CommentRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
