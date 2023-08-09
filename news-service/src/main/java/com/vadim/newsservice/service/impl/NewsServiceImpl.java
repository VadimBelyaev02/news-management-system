package com.vadim.newsservice.service.impl;

import com.vadim.newsservice.exception.NotFoundException;
import com.vadim.newsservice.model.dto.request.NewsRequestDto;
import com.vadim.newsservice.model.dto.response.NewsResponseDto;
import com.vadim.newsservice.model.dto.response.PageResponse;
import com.vadim.newsservice.model.entity.News;
import com.vadim.newsservice.model.mapper.NewsMapper;
import com.vadim.newsservice.repository.NewsRepository;
import com.vadim.newsservice.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.vadim.newsservice.utils.constants.NewsConstants.NEWS_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;
    private final NewsMapper mapper;

    @Override
    @Transactional(readOnly = true)
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
    public NewsResponseDto save(NewsRequestDto requestDto) {
        News news = mapper.toEntity(requestDto);
        News savedNews = repository.save(news);
        return mapper.toResponseDto(savedNews);
    }

    @Override
    @Transactional
    public NewsResponseDto update(UUID id, NewsRequestDto newsDtoRequest) {
        News news = repository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(NEWS_NOT_FOUND_BY_ID, id))
        );
        mapper.updateEntityFromRequestDto(newsDtoRequest, news);
        return mapper.toResponseDto(news);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(String.format(NEWS_NOT_FOUND_BY_ID, id));
        }
        repository.deleteById(id);
    }
}
