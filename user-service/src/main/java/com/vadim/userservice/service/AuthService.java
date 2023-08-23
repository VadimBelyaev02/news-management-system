package com.vadim.userservice.service;

import com.vadim.userservice.model.dto.request.LoginRequestDto;
import com.vadim.userservice.model.dto.request.RegistrationRequestDto;
import com.vadim.userservice.model.dto.response.UserResponseDto;

public interface AuthService {

    UserResponseDto register(RegistrationRequestDto requestDto);

    void login(LoginRequestDto requestDto);

    void confirmRegistration(String code);
}
