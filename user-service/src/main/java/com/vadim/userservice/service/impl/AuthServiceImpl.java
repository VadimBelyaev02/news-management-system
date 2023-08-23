package com.vadim.userservice.service.impl;

import com.vadim.userservice.exception.DuplicateRecordException;
import com.vadim.userservice.exception.UserNotFoundException;
import com.vadim.userservice.model.dto.request.LoginRequestDto;
import com.vadim.userservice.model.dto.request.RegistrationRequestDto;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.model.entity.User;
import com.vadim.userservice.model.enums.UserRole;
import com.vadim.userservice.model.enums.UserStatus;
import com.vadim.userservice.model.mapper.UserMapper;
import com.vadim.userservice.repository.UserRepository;
import com.vadim.userservice.service.AuthService;
import com.vadim.userservice.service.mail.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import static com.vadim.userservice.util.constants.UserConstants.USER_EXISTS_BY_EMAIL;
import static com.vadim.userservice.util.constants.UserConstants.USER_EXISTS_BY_USERNAME;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final MailSender mailSender;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;
    private final RedisTemplate<String, UUID> redisTemplate;

    @Override
    public UserResponseDto register(RegistrationRequestDto requestDto) {
        if (userRepository.existsByUsername(requestDto.getUsername())) {
            throw new DuplicateRecordException(USER_EXISTS_BY_USERNAME, requestDto.getUsername());
        }
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new DuplicateRecordException(USER_EXISTS_BY_EMAIL, requestDto.getEmail());
        }
        User user = mapper.toEntity(requestDto);
        user.setPassword(encoder.encode(requestDto.getPassword()));

        User savedUser = userRepository.save(user);
        String code = String.valueOf(UUID.randomUUID());
        mailSender.sendConfirmationButton(savedUser.getEmail(), "NEWS Account confirmation", code);
        redisTemplate.opsForValue().set(code, savedUser.getId());
        return mapper.toResponseDto(savedUser);
    }


    public void confirmRegistration(String code) {
        UUID userId = redisTemplate.opsForValue().get(code);
        if (Objects.nonNull(userId)) {
            User user = userRepository.findById(userId).orElseThrow(
                    UserNotFoundException::new
            );
            user.setStatus(UserStatus.ACTIVE);
        }
    }
    /*
        private String username;

        @NotBlank(message = "Email can't be empty")
        @Size(min = 5, max = 50, message = "Username length must be from 5 to 50")
        private String email;
        private String avatar;

        @NotBlank(message = "Password can't be empty")
        @Size(min = 6, max = 30, message = "Password length must be from 6 to 30")
        private String password;
     */
    @Override
    public void login(LoginRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.)
    }
}
