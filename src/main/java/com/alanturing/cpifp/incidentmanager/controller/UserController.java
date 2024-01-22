package com.alanturing.cpifp.incidentmanager.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alanturing.cpifp.incidentmanager.domain.UserEntity;
import com.alanturing.cpifp.incidentmanager.service.UserService;

@Controller 
@RequestMapping("api/user") 
public class UserController {

  private UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

  @PostMapping() 
    public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email, @RequestParam String surname
      , @RequestParam String password, @RequestParam LocalDate birthDate ) {
    

      service.addNewUser(name, email, surname, password, birthDate);
      return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<UserEntity> getAllUsers() {
   
     return service.getAll();

    }
    
}
