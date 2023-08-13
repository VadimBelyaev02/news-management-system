package com.vadim.newsservice.service.impl;

import com.vadim.newsservice.client.UserFeignClient;
import com.vadim.newsservice.client.model.dto.UserResponseDto;
import com.vadim.newsservice.client.model.enums.Permission;
import com.vadim.newsservice.exception.NotFoundException;
import com.vadim.newsservice.model.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {

    private final UserFeignClient userFeignClient;

    private String currentToken;

    private UserResponseDto currentUser;

    public UserResponseDto currentUser(String token) {
        if (currentToken.equals(token)) {
            return currentUser;
        }
        final ApiResponse<UserResponseDto> body = userFeignClient.getUserByToken(token).getBody();
        UserResponseDto userResponseDto = Optional.ofNullable(body).orElseThrow(
                () -> new NotFoundException("")
        ).getData();
        currentUser = userResponseDto;
        currentToken = token;
        return currentUser;
    }

    private UserResponseDto getUser(String token) {
        return Optional.ofNullable(userFeignClient.getUserByToken(token).getBody())
                .orElseThrow(() -> new NotFoundException(""))
                .getData();
    }

    public boolean canDeleteComment(String username, String token) {
        UserResponseDto user = getUser(token);
        return user.username().equals(username) || user.role().getPermissions()
                .contains(Permission.DELETE_COMMENT);
    }

    public boolean canModifyComment(String username, String token) {
        UserResponseDto user = getUser(token);
        return user.username().equals(username) || user.role().getPermissions()
                .contains(Permission.UPDATE_COMMENT);
    }

    public boolean canCreateComments(String token) {
        UserResponseDto user = getUser(token);
        return user.role().getPermissions().contains(Permission.CREATE_COMMENT);
    }


}
