package com.vadim.newsservice.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@Builder
public class NewsRequestDto {

    @Size(min = 10, max = 255, message = "News title must be from 10 to 255")
    private String title;

    @Size(min = 10, max = 10000, message = "News text must be form 10 to 1000")
    private String text;
}
