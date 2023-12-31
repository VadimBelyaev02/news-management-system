package com.vadim.newsservice.controller;

import com.vadim.newsservice.aop.annotations.Log;
import com.vadim.newsservice.model.dto.request.NewsRequestDto;
import com.vadim.newsservice.model.dto.response.ApiResponse;
import com.vadim.newsservice.model.dto.response.NewsResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import com.vadim.newsservice.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vadim.newsservice.utils.constants.NewsConstants.NEWS_API_PATH;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping(NEWS_API_PATH)
public class NewsController {

    private final NewsService service;

    @GetMapping("/{newsId}")
    public ResponseEntity<ApiResponse<NewsResponseDto>> getNews(@PathVariable UUID newsId) {
        NewsResponseDto newsResponseDto = service.getById(newsId);

        return ApiResponse.ok(
                "News with id = " + newsId,
                NEWS_API_PATH + "/" + newsId,
                newsResponseDto
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<NewsResponseDto>>> getAllNews(Pageable pageable) {
        PageResponse<NewsResponseDto> newsResponseDtoPage = service.getAll(pageable);

        return ApiResponse.ok(
                "All news",
                NEWS_API_PATH,
                newsResponseDtoPage
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<NewsResponseDto>> postNews(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
            @RequestBody @Valid NewsRequestDto newsRequestDto) {
        NewsResponseDto newsResponseDto = service.save(newsRequestDto, authorization);

        return ApiResponse.created(
                "News with id = " + newsResponseDto.id() + " was created",
                NEWS_API_PATH,
                newsResponseDto
        );
    }

    @PutMapping("/{newsId}")
    public ResponseEntity<ApiResponse<NewsResponseDto>> putNews(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
            @RequestBody @Valid NewsRequestDto newsRequestDto,
            @PathVariable UUID newsId) {
        NewsResponseDto newsResponseDto = service.update(newsId, newsRequestDto, authorization);

        return ApiResponse.ok(
                "News with id = " + newsId + " was updated ",
                NEWS_API_PATH,
                newsResponseDto
        );
    }

    @DeleteMapping("/{newsId}")
    public ResponseEntity<ApiResponse<Void>> deleteNews(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
            @PathVariable UUID newsId) {
        service.deleteById(newsId, authorization);

        return ApiResponse.noContent(
                "News with id = " + newsId + " was deleted",
                NEWS_API_PATH
        );
    }
}
