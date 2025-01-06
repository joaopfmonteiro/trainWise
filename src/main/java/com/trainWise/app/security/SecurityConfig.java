package com.trainWise.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Desativa CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register").permitAll() // Permite acesso sem autenticação
                        .anyRequest().authenticated() // Outras rotas exigem autenticação
                )
                .httpBasic(Customizer.withDefaults()) // Corrige erro no Spring Boot 3 / Security 6
                .build();
    }
}
