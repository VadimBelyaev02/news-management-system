package com.vadim.grpcservice.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


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

