package com.vadim.userservice.model.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhotoRequestDto {

    //  @JsonIgnore
    private MultipartFile image;
    private boolean isAvatar = false;
}
