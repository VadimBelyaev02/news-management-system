package com.vadim.userservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class PhotoResponseDto {
    private UUID id;
    private String url;
    private boolean isAvatar;

}
