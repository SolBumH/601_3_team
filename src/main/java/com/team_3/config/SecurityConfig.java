package com.team_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/login").permitAll() // 로그인을 안해도 모든 사용자 허가
                        .requestMatchers("/admin").hasRole("ADMIN") // /admin은 ADMIN 사용자만
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // my 밑의 경로는 로그인 한 사용자만
                        .anyRequest().authenticated() // 로그인만 하면 가능
                );

        return http.build();
    }

}
