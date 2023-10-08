package com.vadim.userservice.model.unsplash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediumInfo {
    private String filename;
    private String name;
    private String mime;
    private String extension;
    private String url;

    // Геттеры и сеттеры
}

