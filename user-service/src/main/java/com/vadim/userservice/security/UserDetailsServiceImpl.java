package com.vadim.userservice.security;

import com.vadim.userservice.exception.RecordNotFoundException;
import com.vadim.userservice.exception.UserNotFoundException;
import com.vadim.userservice.model.entity.User;
import com.vadim.userservice.repository.UserRepository;
import com.vadim.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                UserNotFoundException::new
        );
        return SecurityUser.fromUser(user);
    }
}
