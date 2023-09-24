package com.vadim.userservice.model.mapper;

import com.vadim.userservice.model.dto.request.PhotoRequestDto;
import com.vadim.userservice.model.entity.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PhotoMapper {

    @Mapping(target = "url", ignore = true)
    @Mapping(target = "isAvatar", source = "isAvatar")
    Photo toEntity(PhotoRequestDto requestDto);
}
