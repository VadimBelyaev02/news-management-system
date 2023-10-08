package com.vadim.userservice.service.impl;

import com.vadim.userservice.exception.DuplicateRecordException;
import com.vadim.userservice.exception.RecordNotFoundException;
import com.vadim.userservice.exception.UserNotFoundException;
import com.vadim.userservice.model.dto.request.LoginRequestDto;
import com.vadim.userservice.model.dto.request.RegistrationRequestDto;
import com.vadim.userservice.model.dto.response.AuthResponseDto;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.model.entity.User;
import com.vadim.userservice.model.enums.UserStatus;
import com.vadim.userservice.model.mapper.UserMapper;
import com.vadim.userservice.repository.PhotoRepository;
import com.vadim.userservice.repository.UserRepository;
import com.vadim.userservice.security.jwt.JwtTokenProvider;
import com.vadim.userservice.service.AuthService;
import com.vadim.userservice.service.PhotoService;
import com.vadim.userservice.service.mail.MailSender;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static com.vadim.userservice.util.constants.UserConstants.*;

@Service
//@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final MailSender mailSender;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;
    private final RedisTemplate<String, String> redisTemplate;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final PhotoService photoService;
    private final PhotoRepository photoRepository;

    public AuthServiceImpl(UserRepository userRepository,
                           MailSender mailSender,
                           PasswordEncoder encoder,
                           UserMapper mapper,
                           RedisTemplate<String, String> redisTemplate,
                           AuthenticationManager authenticationManager,
                           JwtTokenProvider tokenProvider,
                           PhotoService photoService, PhotoRepository photoRepository) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
        this.encoder = encoder;
        this.mapper = mapper;
        this.redisTemplate = redisTemplate;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.photoService = photoService;
        this.photoRepository = photoRepository;
    }


    @Override
    @Transactional
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
        // it's not gonna send an email due to the fact that google deleted the account which used to send emails
        //   mailSender.sendConfirmationButton(savedUser.getEmail(), "NEWS email confirmation", code);
        //redisTemplate.opsForValue().set(code, savedUser.getUsername());
        return mapper.toResponseDto(savedUser);
    }


    @Override
    @Transactional
    public UserResponseDto confirmRegistration(String code) {
        String username = Optional.ofNullable(redisTemplate.opsForValue().get(code)).orElseThrow(
                RecordNotFoundException::new
        );
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User with username = " + username + " is not found")
        );
        user.setStatus(UserStatus.ACTIVE);
        return mapper.toResponseDto(user);
    }

    @Override
    @Transactional
    public AuthResponseDto login(LoginRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername()).orElseThrow(
                () -> new UserNotFoundException(USER_NOT_FOUND_BY_EMAIL, requestDto.getUsername())
        );
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                requestDto.getUsername(), requestDto.getPassword()
        ));
        String token = tokenProvider.createToken(requestDto.getUsername(), user.getRole().name());
        return new AuthResponseDto(token, user.getId());
    }
}
