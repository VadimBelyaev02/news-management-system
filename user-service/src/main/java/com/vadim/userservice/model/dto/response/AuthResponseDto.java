package com.vadim.userservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

public record AuthResponseDto(
        String token,
        UUID userId

){


}
