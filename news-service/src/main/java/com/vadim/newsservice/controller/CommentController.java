package com.vadim.newsservice.controller;


import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.ApiResponseDto;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponseDto;
import com.vadim.newsservice.service.CommentService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
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
    public ApiResponseDto<CommentResponseDto> getComment(@PathVariable UUID commentId) {

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<PageResponseDto<CommentResponseDto>> getAllComments() {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<CommentResponseDto> postComments(@RequestBody @Valid CommentRequestDto requestDto) {

    }

    @PutMapping("/{commentId}")
    public ApiResponseDto<CommentResponseDto> putComments(@RequestBody @Valid CommentRequestDto requestDto,
                                                          @PathVariable UUID commentId) {

    }
}
