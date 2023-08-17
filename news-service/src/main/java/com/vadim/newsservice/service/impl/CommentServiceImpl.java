package com.vadim.newsservice.service.impl;

import com.vadim.newsservice.aop.annotations.Log;
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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.vadim.newsservice.utils.constants.CommentConstants.COMMENT_NOT_FOUND_BY_ID;

@Log
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;
    private final AuthenticationServiceImpl authenticationService;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "comment", key = "#id")
    public CommentResponseDto getById(UUID id) {
        Comment comment = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(COMMENT_NOT_FOUND_BY_ID, id))
        );
        return mapper.toResponseDto(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse<CommentResponseDto> getAll(Pageable pageable) {
        List<CommentResponseDto> commentResponseDtos = repository.findAll(pageable).stream()
                .map(mapper::toResponseDto)
                .toList();
        return PageResponse.response(pageable, commentResponseDtos);
    }


    @Override
    @Transactional(readOnly = true)
    public PageResponse<CommentResponseDto> getAllByCriteria(Pageable pageable, CommentCriteria criteria) {
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
    @CachePut(value = "comment", key = "#result.id()")
    public CommentResponseDto save(CommentRequestDto requestDto, String token) {
//        if (!authenticationService.canCreateComments(token)) {
//            throw new AccessDeniedException(String.format(NO_ACCESS_TO_CREATE_COMMENT));
//        }

        Comment comment = mapper.toEntity(requestDto);
        Comment savedComment = repository.save(comment);
        return mapper.toResponseDto(savedComment);
    }

    @Override
    @Transactional
    @CachePut(value = "comment", key = "#id")
    public CommentResponseDto update(UUID id, CommentRequestDto requestDto, String token) {
        Comment comment = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(COMMENT_NOT_FOUND_BY_ID, id))
        );
//        if (!authenticationService.canModifyComment(comment.getUsername(), token)) {
//            throw new AccessDeniedException(String.format(NO_ACCESS_TO_UPDATE_COMMENT, id));
//        }

        mapper.updateEntityFromRequestDto(requestDto, comment);
        return mapper.toResponseDto(comment);
    }

    @Override
    @Transactional
    @CacheEvict(value = "comment", key = "#id")
    public void deleteById(UUID id, String token) {
//        if (!repository.existsById(id)) {
//            throw new NotFoundException(String.format(COMMENT_NOT_FOUND_BY_ID, id));
//        }
        Comment comment = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(COMMENT_NOT_FOUND_BY_ID, id))
        );
//        if (!authenticationService.canDeleteComment(comment.getUsername(), token)) {
//            throw new AccessDeniedException(String.format(NO_ACCESS_TO_UPDATE_COMMENT, id));
//        }
        repository.deleteById(id);
    }
}
