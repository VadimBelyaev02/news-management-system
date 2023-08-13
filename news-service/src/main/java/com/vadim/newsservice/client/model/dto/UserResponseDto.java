package com.vadim.newsservice.client.model.dto;

import com.vadim.newsservice.client.model.enums.UserRole;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponseDto(
        UUID id,
        String username,
        String email,
        String createdDate,
        String status,

        UserRole role
) {
}