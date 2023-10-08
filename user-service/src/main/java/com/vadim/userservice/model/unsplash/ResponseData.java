package com.vadim.userservice.model.unsplash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private ImageData data;
    private boolean success;
    private int status;

    // Геттеры и сеттеры
}
