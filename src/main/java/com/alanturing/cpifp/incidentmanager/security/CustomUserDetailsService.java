package com.alanturing.cpifp.incidentmanager.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;
import com.alanturing.cpifp.incidentmanager.domain.users.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository repository;
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("No esiste"));
        UserDetails userDetails = User.withUsername(user.getEmail())
        .password(user.getPassword())
        .roles(user.getRol())
        .build();
        return userDetails;
    }
}
