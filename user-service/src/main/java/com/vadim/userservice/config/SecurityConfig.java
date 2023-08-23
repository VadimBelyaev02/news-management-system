package com.vadim.userservice.config;

import com.vadim.userservice.security.jwt.JwtTokenConfigurer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenConfigurer jwtTokenConfigurer;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            //    .authorizeRequests()
              //  .anyRequest()
                //.authenticated()
                //.and()
                .authorizeRequests()
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(jwtTokenConfigurer);
        return httpSecurity.build();
    }
}
