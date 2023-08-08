package com.vadim.newsservice.service.impl;

import com.vadim.newsservice.model.criteria.CommentCriteria;
import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponseDto;
import com.vadim.newsservice.model.entity.Comment;
import com.vadim.newsservice.model.mapper.CommentMapper;
import com.vadim.newsservice.repository.CommentRepository;
import com.vadim.newsservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;

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
