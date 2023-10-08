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
public class ImageData {
    private String id;
    private String title;
    private String url_viewer;
    private String url;
    private String display_url;
    private String width;
    private String height;
    private String size;
    private String time;
    private String expiration;
    private ImageInfo image;
    private ThumbnailInfo thumb;
    private MediumInfo medium;
    private String delete_url;

    // Геттеры и сеттеры
}

