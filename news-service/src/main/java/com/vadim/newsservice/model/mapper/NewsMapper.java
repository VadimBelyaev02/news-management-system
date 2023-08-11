package com.vadim.newsservice.model.mapper;

import com.vadim.newsservice.model.dto.request.NewsRequestDto;
import com.vadim.newsservice.model.dto.response.NewsResponseDto;
import com.vadim.newsservice.model.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface NewsMapper {

    News toEntity(NewsRequestDto requestDto);

    @Mapping(target = "comments", ignore = true)
    NewsResponseDto toResponseDto(News news);

    void updateEntityFromRequestDto(NewsRequestDto requestDto, @MappingTarget News news);
}
