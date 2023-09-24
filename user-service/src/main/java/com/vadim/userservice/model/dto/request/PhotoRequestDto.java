package com.vadim.userservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhotoRequestDto {
    private MultipartFile photo;
    private boolean isAvatar = false;
}
