package com.vadim.userservice.model.mapper;

import com.vadim.userservice.model.dto.request.UserRequestDto;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    User toEntity(UserRequestDto requestDto);

    UserResponseDto toResponseDto(User comment);

    void updateEntityFromRequestDto(UserRequestDto requestDto, @MappingTarget User comment);
}
