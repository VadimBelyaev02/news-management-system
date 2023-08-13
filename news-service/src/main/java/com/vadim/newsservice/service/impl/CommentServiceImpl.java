package com.vadim.newsservice.service.impl;

import com.vadim.newsservice.exception.NotFoundException;
import com.vadim.newsservice.model.criteria.CommentCriteria;
import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import com.vadim.newsservice.model.entity.Comment;
import com.vadim.newsservice.model.mapper.CommentMapper;
import com.vadim.newsservice.repository.CommentRepository;
import com.vadim.newsservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.vadim.newsservice.utils.constants.CommentConstants.COMMENT_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public CommentResponseDto getById(UUID id) {
        Comment comment = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(COMMENT_NOT_FOUND_BY_ID, id))
        );
        return mapper.toResponseDto(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse<CommentResponseDto> getAll(Pageable pageable, CommentCriteria criteria) {
        Comment searchComment = new Comment();
        searchComment.setText(criteria.getText());
        searchComment.setUsername(criteria.getUsername());

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase(true)
                .withIgnoreNullValues();

        Example<Comment> example = Example.of(searchComment, matcher);

        List<CommentResponseDto> comments = repository.findAll(example, pageable).stream()
                .map(mapper::toResponseDto)
                .toList();

        return PageResponse.response(pageable, comments);
    }

    @Override
    @Transactional
    public CommentResponseDto save(CommentRequestDto requestDto, String token) {
        Comment comment = mapper.toEntity(requestDto);
        Comment savedComment = repository.save(comment);
        return mapper.toResponseDto(savedComment);
    }

    @Override
    @Transactional
    public CommentResponseDto update(UUID id, CommentRequestDto requestDto, String token) {
        Comment comment = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(COMMENT_NOT_FOUND_BY_ID, id))
        );
        mapper.updateEntityFromRequestDto(requestDto, comment);
        return mapper.toResponseDto(comment);
    }

    @Override
    @Transactional
    public void deleteById(UUID id, String token) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(String.format(COMMENT_NOT_FOUND_BY_ID, id));
        }
        repository.deleteById(id);
    }
}
