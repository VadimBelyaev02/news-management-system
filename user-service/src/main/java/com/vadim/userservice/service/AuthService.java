package com.vadim.userservice.service;

import com.vadim.userservice.model.dto.request.AuthRequestDto;
import com.vadim.userservice.model.dto.request.RegistrationRequestDto;

public interface AuthService {

    void register(RegistrationRequestDto requestDto);

    void authenticate(AuthRequestDto requestDto);

    void confirm(String code);

}
