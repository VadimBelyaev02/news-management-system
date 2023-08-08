package com.vadim.newsservice.model.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CommentRequestDto {

    @Size(min = 10, max = 255, message = "Comment text length must be from 10 to 255")
    private String text;

    @Size(min = 5, max = 255, message = "Username length must be from 10 to 255")
    private String username;
}
