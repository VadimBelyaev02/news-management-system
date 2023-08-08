package com.vadim.newsservice.service.impl;

import com.vadim.newsservice.model.criteria.NewsCriteria;
import com.vadim.newsservice.model.dto.request.NewsRequestDto;
import com.vadim.newsservice.model.dto.response.NewsResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponseDto;
import com.vadim.newsservice.model.entity.News;
import com.vadim.newsservice.model.mapper.NewsMapper;
import com.vadim.newsservice.repository.NewsRepository;
import com.vadim.newsservice.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;
    private final NewsMapper mapper;
    @Override
    public NewsResponseDto getById(UUID id) {
        News news = repository.findById(id).orElseThrow(() ->
                )
    }

    @Override
    public PageResponseDto<NewsResponseDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public PageResponseDto<NewsResponseDto> getAllByCriteria(NewsCriteria searchCriteria, Pageable pageable) {
        return null;
    }

    @Override
    public NewsResponseDto update(UUID id, NewsRequestDto newsDtoRequest) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
