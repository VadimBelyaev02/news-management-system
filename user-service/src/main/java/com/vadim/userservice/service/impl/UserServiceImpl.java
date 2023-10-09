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

import java.util.List;
import java.util.UUID;

import static com.vadim.userservice.util.constants.UserConstants.USER_NOT_FOUND_BY_USERNAME;

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
        List<UserResponseDto> users = repository.findAll(pageable).stream()
                .map(mapper::toResponseDto)
                .toList();

        return PageResponse.response(pageable, users);
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

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getByUsername(String username) {
        User user = repository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException(USER_NOT_FOUND_BY_USERNAME, username)
        );
        return mapper.toResponseDto(user);
    }
}
