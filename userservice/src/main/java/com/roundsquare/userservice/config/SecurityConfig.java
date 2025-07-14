package com.roundsquare.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/users/login", "/users/register", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/users/allUsers", "/users/{id}", "/users/{id}/update").authenticated()
                        .anyRequest().authenticated()).build();

    }

}
