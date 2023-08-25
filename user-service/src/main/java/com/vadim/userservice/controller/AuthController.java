package com.vadim.userservice.controller;

import com.vadim.userservice.model.dto.request.LoginRequestDto;
import com.vadim.userservice.model.dto.request.RegistrationRequestDto;
import com.vadim.userservice.model.dto.response.ApiResponse;
import com.vadim.userservice.model.dto.response.AuthResponseDto;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vadim.userservice.util.constants.AuthConstants.AUTH_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH_URL)
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDto>> register(@Valid @RequestBody RegistrationRequestDto requestDto) {
        UserResponseDto userResponseDto = service.register(requestDto);

        return ApiResponse.created(
                "A new user was registered",
                AUTH_URL + "/register",
                userResponseDto
        );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto) {
        AuthResponseDto userResponseDto = service.login(requestDto);

        return ApiResponse.ok(
                "A user was logged in",
                AUTH_URL + "/login",
                userResponseDto
        );
    }

    @PatchMapping("/register/confirm")
    public ResponseEntity<ApiResponse<UserResponseDto>> confirmRegistration(@RequestParam("code") String code) {
        UserResponseDto userResponseDto = service.confirmRegistration(code);

        return ApiResponse.ok(
                "The user was confirmed",
                AUTH_URL + "/register/confirm",
                userResponseDto
        );
    }
}
