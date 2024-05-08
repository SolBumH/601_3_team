package com.team_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((auth) -> auth
        		   .requestMatchers("/", "/login", "/loginPage", "/join", "/joinProc", "/**").permitAll() // 로그인을 안해도 모든 사용자 허가
                        .requestMatchers("/admin").hasRole("ADMIN") // /admin은 ADMIN 사용자만
                        .requestMatchers("/mypage/**").hasAnyRole("ADMIN", "USER") // my 밑의 경로는 로그인 한 사용자만
                        .anyRequest().authenticated() // 로그인만 하면 가능
                );
        
        // 로그인이 안되어 오류 페이지 발생 시 로그인 페이지로 이동
        http.formLogin((auth) -> auth.loginPage("/login")
        		.loginProcessingUrl("/login")  // 로그인 시 해당 URL로 값 전송
        		.permitAll());
        
        http.csrf((auth) -> auth.disable()); // 개발 중에는 잠시 꺼두기
        
        return http.build();
    }

}
