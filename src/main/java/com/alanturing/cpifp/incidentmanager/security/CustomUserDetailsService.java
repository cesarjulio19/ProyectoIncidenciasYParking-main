package com.alanturing.cpifp.incidentmanager.security;

import org.springframework.context.annotation.Bean;
/*import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;
import com.alanturing.cpifp.incidentmanager.domain.users.UserRepository;

public class CustomUserDetailsService /*implements UserDetailsService*/{

    /*private UserRepository repository;
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UserEntity user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("No esiste"));
        UserDetails userDetails = User.withDefaultPasswordEncoder().username("Borja")
        .password( user.getPassword() "1234")
        .roles(/*user.getRol()"ADMIN")
        .build();
        return userDetails;
    }*/

    /*@Bean 
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
