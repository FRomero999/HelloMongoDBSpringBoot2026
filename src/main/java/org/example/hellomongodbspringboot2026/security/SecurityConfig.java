package org.example.hellomongodbspringboot2026.security;

import jakarta.servlet.http.HttpServletResponse;
import org.example.hellomongodbspringboot2026.entities.ErrorResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import tools.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/apiv2/teams").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/apiv2/teams/**").permitAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(basic -> {
                    basic.authenticationEntryPoint(customAuthenticationEntryPoint());
                })  // Sintaxis para Spring Security 6.x
                .csrf(csrf -> csrf.disable());  // Sintaxis actualizada también
        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return (request, response, authException) -> {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ErrorResponse errorResponse = new ErrorResponse(
                    "No autorizado",
                    "Unauthorized",
                    "Debe proporcionar credenciales válidas para acceder a este recurso"
            );
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(errorResponse));
        };
    }
/*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123")  // {noop} indica que la contraseña no está encriptada
                .roles("ADMIN")
                .build();

        *
        * Lo probamos asi:
        * POST http://localhost:8080/apiv2/teams
        * Content-Type: application/json
        * Authorization: Basic YWRtaW46YWRtaW4xMjM=
        * *

        return new InMemoryUserDetailsManager(admin);
    }
    */
}