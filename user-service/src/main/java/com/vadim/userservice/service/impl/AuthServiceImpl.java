package com.vadim.userservice.service.impl;

import com.vadim.userservice.model.dto.request.AuthRequestDto;
import com.vadim.userservice.model.dto.request.RegistrationRequestDto;
import com.vadim.userservice.repository.UserRepository;
import com.vadim.userservice.service.AuthService;
import com.vadim.userservice.service.mail.MailSender;
import com.vadim.userservice.service.mail.impl.MailSenderImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final MailSender mailSender;
    @Override
    public void register(RegistrationRequestDto requestDto) {

    }

    @Override
    public void authenticate(AuthRequestDto requestDto) {

    }

    @Override
    public void confirm(String code) {

    }
}
