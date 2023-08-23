package com.vadim.userservice.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class JwtToken {

    private String token;

    private UUID userId;
}
