package com.vadim.userservice.model.dto.request;

import com.vadim.userservice.model.enums.UserRole;
import com.vadim.userservice.model.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String email;
    private List<PhotoRequestDto> photos;
}
