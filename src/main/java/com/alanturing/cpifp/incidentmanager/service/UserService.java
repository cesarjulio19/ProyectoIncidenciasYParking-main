package com.alanturing.cpifp.incidentmanager.service;


import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestParam;

import com.alanturing.cpifp.incidentmanager.domain.UserEntity;
public interface UserService {

    public Iterable<UserEntity> getAll();

    public String addNewUser(@RequestParam String name
      , @RequestParam String email, @RequestParam String surname
      , @RequestParam String password, @RequestParam LocalDate birthDate  );
    

}
