package com.vadim.newsservice.service;

import com.vadim.newsservice.model.criteria.NewsCriteria;
import com.vadim.newsservice.model.dto.request.NewsRequestDto;
import com.vadim.newsservice.model.dto.response.NewsResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NewsService {

    NewsResponseDto getById(UUID id);

    PageResponse<NewsResponseDto> getAll(Pageable pageable);

    NewsResponseDto save(NewsRequestDto requestDto, String token);
    NewsResponseDto update(UUID id, NewsRequestDto newsDtoRequest, String token);

    void deleteById(UUID id, String token);
}
