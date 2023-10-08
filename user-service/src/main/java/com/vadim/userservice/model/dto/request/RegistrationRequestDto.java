package com.vadim.userservice.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegistrationRequestDto {

    @NotBlank(message = "Username can't be empty")
    @Size(min = 5, max = 50, message = "Username length must be from 5 to 50")
    private String username;

    @NotBlank(message = "Email can't be empty")
    @Size(min = 5, max = 50, message = "Email length must be from 5 to 50")
    private String email;

    @NotBlank(message = "Password can't be empty")
    @Size(min = 6, max = 30, message = "Password length must be from 6 to 30")
    private String password;
}
