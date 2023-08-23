package com.vadim.userservice.model.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponseDto(
        UUID id,
        String username,
        String email,
        String createdDate,
        String status,
        String role,
        String avatar
) {
}