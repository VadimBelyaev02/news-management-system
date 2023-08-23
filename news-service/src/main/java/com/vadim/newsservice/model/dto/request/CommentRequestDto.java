package com.vadim.newsservice.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CommentRequestDto {

    @NotBlank(message = "Text can't be empty")
    @Size(min = 10, max = 10000, message = "Comment text length must be from 10 to 10000")
    private String text;

    @NotBlank(message = "Username can't be emtpy")
    @Size(min = 5, max = 50, message = "Username length must be from 5 to 50")
    private String username;

    @NotNull(message = "News's id can't be null")
    private UUID newsId;
}
