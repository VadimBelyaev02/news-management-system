package com.vadim.grpcservice.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnsplashPhoto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("urls")
    private UnsplashPhotoUrls urls;
}
