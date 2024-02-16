package com.alanturing.cpifp.incidentmanager.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alanturing.cpifp.incidentmanager.core.user.UserAlreadyExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;
import com.alanturing.cpifp.incidentmanager.service.user.UserService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequestMapping("api/users") 
public class UserController {

  private UserService service;

  public UserController(UserService service) {
      this.service = service;
  }

  @PostMapping() 
  public @ResponseBody String addNewUser (@RequestPart("user") UserEntity entity,
   @RequestParam("file") MultipartFile file) {
    try {
      InputStream iS = file.getInputStream();
      byte[] imageBytes = iS.readAllBytes();
      String contentType = file.getContentType();
      entity.setFile(imageBytes);
      entity.setFileType(contentType);
      service.addNewUser(entity);
    } catch (UserAlreadyExistsException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "Saved";
  }

  @GetMapping()
  public @ResponseBody Iterable<UserEntity> getAllUsers() {
  
    return service.getAll();

  }

  @GetMapping("/{id}")
  public @ResponseBody UserEntity getUser(@PathVariable int id) {
    UserEntity entity = new UserEntity();
    try {
      entity = service.getUser(id);
    } catch (UserDoesNotExistsException e) {
      e.printStackTrace();
    }
    return entity;
  }
  
  @Transactional
  @DeleteMapping("/{id}")
  public @ResponseBody String deleteUser(@PathVariable int id) {
    service.delete(id);
    return "Deleted";
  }

  @PutMapping("/{id}")
  public @ResponseBody String updateUser(@PathVariable int id, @RequestBody UserEntity entity) {
    try {
      service.updateUser(id, entity);
    } catch (UserDoesNotExistsException e) {
      e.printStackTrace();
    }
    return "Updated";
  }
}
