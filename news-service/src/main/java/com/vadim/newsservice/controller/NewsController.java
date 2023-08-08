package com.vadim.newsservice.controller;

import com.vadim.newsservice.model.dto.request.NewsRequestDto;
import com.vadim.newsservice.model.dto.response.ApiResponse;
import com.vadim.newsservice.model.dto.response.NewsResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import com.vadim.newsservice.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vadim.newsservice.utils.constants.NewsConstants.NEWS_API_PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping
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
    public ResponseEntity<ApiResponse<NewsResponseDto>> postNews(@RequestBody @Valid NewsRequestDto newsRequestDto) {
        NewsResponseDto newsResponseDto = service.save(newsRequestDto);

        return ApiResponse.created(
                "News with id = " + newsResponseDto.id() + " was created",
                NEWS_API_PATH,
                newsResponseDto
        );
    }

    @PutMapping("/{newsId}")
    public ResponseEntity<ApiResponse<NewsResponseDto>> putNews(@RequestBody @Valid NewsRequestDto newsRequestDto,
                                                                @PathVariable UUID newsId) {
        NewsResponseDto newsResponseDto = service.update(newsId, newsRequestDto);

        return ApiResponse.ok(
                "News with id = " + newsId + " was updated ",
                NEWS_API_PATH,
                newsResponseDto
        );
    }

    @DeleteMapping("/{newsId}")
    public ResponseEntity<ApiResponse<Void>> deleteNews(@PathVariable UUID newsId) {
        service.deleteById(newsId);

        return ApiResponse.noContent(
                "News with id = " + newsId + " was deleted",
                NEWS_API_PATH
        );
    }
}
