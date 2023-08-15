package com.vadim.newsservice.service.impl;

import com.vadim.newsservice.aop.annotations.Log;
import com.vadim.newsservice.exception.NotFoundException;
import com.vadim.newsservice.model.dto.request.NewsRequestDto;
import com.vadim.newsservice.model.dto.response.NewsResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import com.vadim.newsservice.model.entity.News;
import com.vadim.newsservice.model.mapper.NewsMapper;
import com.vadim.newsservice.repository.NewsRepository;
import com.vadim.newsservice.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.vadim.newsservice.utils.constants.NewsConstants.NEWS_NOT_FOUND_BY_ID;

@Log
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;
    private final NewsMapper mapper;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "news", key = "#id")
    public NewsResponseDto getById(UUID id) {
        News news = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(NEWS_NOT_FOUND_BY_ID, id))
        );
        return mapper.toResponseDto(news);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse<NewsResponseDto> getAll(Pageable pageable) {
        final List<NewsResponseDto> newsResponseDtos = repository.findAll(pageable).stream()
                .map(mapper::toResponseDto)
                .toList();

        return PageResponse.response(pageable, newsResponseDtos);
    }

    @Override
    @Transactional
    @CachePut(value = "news", key = "#result.id()")
    public NewsResponseDto save(NewsRequestDto requestDto, String token) {
        News news = mapper.toEntity(requestDto);
        News savedNews = repository.save(news);
        return mapper.toResponseDto(savedNews);
    }

    @Override
    @Transactional
    @CachePut(value = "news", key = "#id")
    public NewsResponseDto update(UUID id, NewsRequestDto newsDtoRequest, String token) {
        News news = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(NEWS_NOT_FOUND_BY_ID, id))
        );
        mapper.updateEntityFromRequestDto(newsDtoRequest, news);
        return mapper.toResponseDto(news);
    }

    @Override
    @Transactional
    @CacheEvict(value = "news", key = "#id")
    public void deleteById(UUID id, String token) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(String.format(NEWS_NOT_FOUND_BY_ID, id));
        }
        repository.deleteById(id);
    }
}
