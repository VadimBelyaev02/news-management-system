package com.vadim.newsservice.controller;


import com.vadim.newsservice.aop.annotations.Log;
import com.vadim.newsservice.model.criteria.CommentCriteria;
import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.ApiResponse;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import com.vadim.newsservice.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

import static com.vadim.newsservice.utils.constants.CommentConstants.COMMENT_API_PATH;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping(COMMENT_API_PATH)
public class CommentController {

    private final CommentService service;

    @GetMapping("/{commentId}")
    public ResponseEntity<ApiResponse<CommentResponseDto>> getComment(@PathVariable UUID commentId) {
        CommentResponseDto commentResponseDto = service.getById(commentId);

        return ApiResponse.ok(
                "Comment with id = " + commentId,
                COMMENT_API_PATH,
                commentResponseDto
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CommentResponseDto>>> getAllComments(
            Pageable pageable,
            @RequestParam(required = false, name = "text") String text,
            @RequestParam(required = false, name = "username") String username
    ) {
        CommentCriteria criteria = CommentCriteria.builder()
                .text(text)
                .username(username)
                .build();
        PageResponse<CommentResponseDto> response = Objects.isNull(criteria) ? service.getAll(pageable)
                : service.getAllByCriteria(pageable, criteria);

        return ApiResponse.ok(
                "All comments",
                COMMENT_API_PATH,
                response
        );
    }


    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponseDto>> postComments(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
            @RequestBody @Valid CommentRequestDto commentRequestDto) {
        CommentResponseDto commentResponseDto = service.save(commentRequestDto, authorization);

        return ApiResponse.created(
                "Comment with id = " + commentResponseDto.id() + " was created",
                COMMENT_API_PATH,
                commentResponseDto
        );
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<ApiResponse<CommentResponseDto>> putComments(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
            @RequestBody @Valid CommentRequestDto requestDto,
            @PathVariable UUID commentId) {
        CommentResponseDto commentResponseDto = service.update(commentId, requestDto, authorization);

        return ApiResponse.ok(
                "Comment with id = " + commentId + " was updated",
                COMMENT_API_PATH,
                commentResponseDto
        );
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse<Void>> deleteComment(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
            @PathVariable UUID commentId
    ) {
        service.deleteById(commentId, authorization);

        return ApiResponse.noContent(
                "Comment with id = " + commentId + " was deleted",
                COMMENT_API_PATH
        );
    }
}
