package com.vadim.newsservice.controller;


import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.ApiResponse;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import com.vadim.newsservice.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vadim.newsservice.utils.constants.CommentConstants.COMMENT_API_PATH;

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
    public ResponseEntity<ApiResponse<PageResponse<CommentResponseDto>>> getAllComments(Pageable pageable) {
        PageResponse<CommentResponseDto> commentResponseDtoPage = service.getAll(pageable);

        return ApiResponse.ok(
                "All comments",
                COMMENT_API_PATH,
                commentResponseDtoPage
        );
     }

    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponseDto>> postComments(@RequestBody @Valid CommentRequestDto commentRequestDto) {
        CommentResponseDto commentResponseDto = service.save(commentRequestDto);

        return ApiResponse.created(
                "Comment with id = " + commentResponseDto.id() + " was created",
                COMMENT_API_PATH,
                commentResponseDto
        );
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<ApiResponse<CommentResponseDto>> putComments(@RequestBody @Valid CommentRequestDto requestDto,
                                                       @PathVariable UUID commentId) {
        CommentResponseDto commentResponseDto = service.update(commentId, requestDto);

        return ApiResponse.ok(
                "Comment with id = " + commentId + " was updated",
                COMMENT_API_PATH,
                commentResponseDto
        );
    }
}
