package com.vadim.userservice.model.mapper;

import com.vadim.userservice.model.dto.request.PhotoRequestDto;
import com.vadim.userservice.model.entity.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PhotoMapper {

    Photo toEntity(PhotoRequestDto requestDto);
}
