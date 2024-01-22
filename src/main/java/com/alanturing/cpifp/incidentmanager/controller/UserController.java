package com.alanturing.cpifp.incidentmanager.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alanturing.cpifp.incidentmanager.core.UserAlreadyExistsException;
import com.alanturing.cpifp.incidentmanager.domain.UserEntity;
import com.alanturing.cpifp.incidentmanager.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController 
@RequestMapping("api/users") 
public class UserController {

  private UserService service;

  public UserController(UserService service) {
      this.service = service;
  }

  @PostMapping() 
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, 
  @RequestParam String surname, @RequestParam String password, @RequestParam String address,
  @RequestParam int postalCode, @RequestParam String nif, @RequestParam String schoolYear) {
  
    try {
      service.addNewUser(name, email, surname, password, address, postalCode, nif, schoolYear);
    } catch (UserAlreadyExistsException e) {
      e.printStackTrace();
    }
    return "Saved";
  }

  @GetMapping()
  public @ResponseBody Iterable<UserEntity> getAllUsers() {
  
    return service.getAll();

  }

  @DeleteMapping("/{id}")
  public @ResponseBody void deleteUser(@RequestParam int id) {
    service.delete(id);
  }

  @PutMapping("/{id}")
  public @ResponseBody String updateUser(@RequestParam int id, @RequestParam UserEntity entity) {
    return service.updateUser(id, entity);
  }
}
