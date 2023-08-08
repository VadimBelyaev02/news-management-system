package com.vadim.newsservice.model.mapper;

import com.vadim.newsservice.model.dto.request.CommentRequestDto;
import com.vadim.newsservice.model.dto.response.CommentResponseDto;
import com.vadim.newsservice.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CommentMapper {

    Comment toEntity(CommentRequestDto requestDto);

    CommentResponseDto toResponseDto(Comment comment);

    void updateEntityFromRequestDto(CommentRequestDto requestDto, @MappingTarget Comment comment);
}
