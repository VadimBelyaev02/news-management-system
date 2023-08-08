package com.vadim.newsservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record CommentResponseDto(
         Long id,
         OffsetDateTime time,
         String text,
         String username,
         UUID newsId
) {}
