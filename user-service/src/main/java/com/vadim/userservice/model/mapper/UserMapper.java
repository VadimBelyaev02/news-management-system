package com.vadim.userservice.model.mapper;

import com.vadim.userservice.model.dto.request.RegistrationRequestDto;
import com.vadim.userservice.model.dto.request.UserRequestDto;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    User toEntity(UserRequestDto requestDto);

    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "role", expression = "java(com.vadim.userservice.model.enums.UserRole.SUBSCRIBER)")
    @Mapping(target = "status", expression = "java(com.vadim.userservice.model.enums.UserStatus.NOT_ACTIVE)")
    User toEntity(RegistrationRequestDto requestDto);

    UserResponseDto toResponseDto(User user);

    void updateEntityFromRequestDto(UserRequestDto requestDto, @MappingTarget User user);
}
