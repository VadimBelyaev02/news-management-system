package com.vadim.newsservice.controller;


import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.ApiResponse;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import com.vadim.newsservice.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vadim.newsservice.utils.constants.CommentConstants.COMMENT_API_PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMMENT_API_PATH)
public class CommentController {

    private final CommentService service;

    @GetMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<CommentResponseDto> getComment(@PathVariable UUID commentId) {

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PageResponse<CommentResponseDto>> getAllComments() {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CommentResponseDto> postComments(@RequestBody @Valid CommentRequestDto requestDto) {

    }

    @PutMapping("/{commentId}")
    public ApiResponse<CommentResponseDto> putComments(@RequestBody @Valid CommentRequestDto requestDto,
                                                       @PathVariable UUID commentId) {

    }
}
