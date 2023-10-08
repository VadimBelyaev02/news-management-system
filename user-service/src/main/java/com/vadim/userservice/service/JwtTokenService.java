package com.vadim.userservice.service;

import com.vadim.userservice.model.dto.response.UserResponseDto;

public interface JwtTokenService {

    UserResponseDto getUserByToken(String token);
}
