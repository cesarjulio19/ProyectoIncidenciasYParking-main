package com.alanturing.cpifp.incidentmanager.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.alanturing.cpifp.incidentmanager.domain.UserEntity;
import com.alanturing.cpifp.incidentmanager.domain.UserRepository;

@Service
public class UserSrvicelmpl implements UserService{

  @Autowired 
  private UserRepository userRepository;

    @Override
    public Iterable<UserEntity> getAll() {
        
        return userRepository.findAll();
        
    }

    @Override
    public String addNewUser(@RequestParam String name
      , @RequestParam String email, @RequestParam String surname
      , @RequestParam String password, @RequestParam LocalDate birthDate) {
        
      UserEntity n = new UserEntity();
      n.setName(name);
      n.setEmail(email);
      n.setSurname(surname);
      n.setBirthDate(birthDate);
      n.setPassword(password);
      n.setRol("User");
      n.setParking(false);
      userRepository.save(n);
      return "Saved";
    }
    
}
