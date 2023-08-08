package com.vadim.newsservice.service;

import com.vadim.newsservice.model.criteria.NewsCriteria;
import com.vadim.newsservice.model.dto.request.NewsRequestDto;
import com.vadim.newsservice.model.dto.response.NewsResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NewsService {

    NewsResponseDto getById(UUID id);

    PageResponseDto<NewsResponseDto> getAll(Pageable pageable);

    PageResponseDto<NewsResponseDto> getAllByCriteria(NewsCriteria searchCriteria, Pageable pageable);

    NewsResponseDto update(UUID id, NewsRequestDto newsDtoRequest);

    void deleteById(UUID id);
}
