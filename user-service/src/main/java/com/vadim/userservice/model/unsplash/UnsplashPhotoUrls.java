package com.vadim.userservice.model.unsplash;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnsplashPhotoUrls {
    @JsonProperty("full")
    private String full;

    @JsonProperty("thumb")
    private String thumb;
}

