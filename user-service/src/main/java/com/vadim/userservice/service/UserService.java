package com.vadim.userservice.service;

import com.vadim.userservice.model.criteria.UserCriteria;
import com.vadim.userservice.model.dto.request.UserRequestDto;
import com.vadim.userservice.model.dto.response.PageResponse;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponseDto getById(UUID userId);

    PageResponse<UserResponseDto> getAll(Pageable pageable, UserCriteria userCriteria);

    UserResponseDto save(UserRequestDto userRequestDto);

    UserResponseDto update(UUID userId, UserRequestDto userRequestDto);

    void deleteById(UUID userId);

    UserResponseDto getByUsername(String username);
}
