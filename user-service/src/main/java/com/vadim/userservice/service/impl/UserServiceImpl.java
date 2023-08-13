package com.vadim.userservice.service.impl;

import com.vadim.userservice.exception.UserNotFoundException;
import com.vadim.userservice.model.criteria.UserCriteria;
import com.vadim.userservice.model.dto.request.UserRequestDto;
import com.vadim.userservice.model.dto.response.PageResponse;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.model.entity.User;
import com.vadim.userservice.model.mapper.UserMapper;
import com.vadim.userservice.repository.UserRepository;
import com.vadim.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getById(UUID userId) {
        User user = repository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        return mapper.toResponseDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse<UserResponseDto> getAll(Pageable pageable, UserCriteria userCriteria) {
        return null;
    }

    @Override
    @Transactional
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = mapper.toEntity(userRequestDto);
        User savedUser = repository.save(user);
        return mapper.toResponseDto(savedUser);
    }

    @Override
    @Transactional
    public UserResponseDto update(UUID userId, UserRequestDto userRequestDto) {
        User user = repository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        mapper.updateEntityFromRequestDto(userRequestDto, user);
        return mapper.toResponseDto(user);
    }

    @Override
    @Transactional
    public void deleteById(UUID userId) {
        if (!repository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        repository.deleteById(userId);
    }
}
