package com.alanturing.cpifp.incidentmanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

      @Bean
      SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests( 
            (requests) -> requests.requestMatchers("/register").permitAll()
            .requestMatchers("/csrf").permitAll()
            .requestMatchers("/login").permitAll()
            .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
		return http.build();
      }

      @Bean
      public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
      }
}
