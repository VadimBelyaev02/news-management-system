package com.vadim.userservice.service.impl;

import com.vadim.userservice.exception.AccessDeniedException;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.security.jwt.JwtTokenProvider;
import com.vadim.userservice.service.JwtTokenService;
import com.vadim.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Override
    public UserResponseDto getUserByToken(String token) {
        if (!jwtTokenProvider.validateToken(token)) {
            throw new AccessDeniedException("Invalid token: " + token);
        }
        String username = jwtTokenProvider.getUsername(token);
        return userService.getByUsername(username);
    }
}
