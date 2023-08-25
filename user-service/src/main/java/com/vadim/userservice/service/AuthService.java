package com.vadim.userservice.service;

import com.vadim.userservice.model.dto.request.LoginRequestDto;
import com.vadim.userservice.model.dto.request.RegistrationRequestDto;
import com.vadim.userservice.model.dto.response.AuthResponseDto;
import com.vadim.userservice.model.dto.response.UserResponseDto;

public interface AuthService {

    UserResponseDto register(RegistrationRequestDto requestDto);

    AuthResponseDto login(LoginRequestDto requestDto);

    UserResponseDto confirmRegistration(String code);
}
