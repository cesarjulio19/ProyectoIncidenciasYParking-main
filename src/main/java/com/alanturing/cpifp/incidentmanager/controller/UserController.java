package com.alanturing.cpifp.incidentmanager.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;*/
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
@RequestMapping() 
public class UserController {

  private final UserService service;
  //private PasswordEncoder encoder;

  public UserController(UserService service) {
      this.service = service;
      //this.encoder = new BCryptPasswordEncoder();
  }

  @PostMapping("register") 
  public @ResponseBody String addNewUser (@RequestBody UserEntity entity//,
   /*@RequestParam("file") MultipartFile file*/) {
    try {
      /*InputStream iS = file.getInputStream();
      byte[] imageBytes = iS.readAllBytes();
      String contentType = file.getContentType();
      entity.setFile(imageBytes);
      entity.setFileType(contentType);*/
      //String encodedPassword = this.encoder.encode(entity.getPassword());
      //entity.setPassword(encodedPassword);
      service.addNewUser(entity);
    } catch (UserAlreadyExistsException e) {
      e.printStackTrace();
    }/*  catch (IOException e) {
      e.printStackTrace();
    }*/
    return entity.getPassword();
  }

  @GetMapping("api/users")
  public @ResponseBody Iterable<UserEntity> getAllUsers() {
  
    return service.getAll();

  }

  /*@GetMapping("api/users/{id}")
  public @ResponseBody UserEntity getUser(@PathVariable int id) {
    UserEntity entity = new UserEntity();
    try {
      entity = service.getUser(id);
    } catch (UserDoesNotExistsException e) {
      e.printStackTrace();
    }
    return entity;
  }*/

  @GetMapping("api/users/{email}")
  public @ResponseBody UserEntity getUserByEmail(@PathVariable String email) {
    UserEntity entity = new UserEntity();
    try {
      entity = service.getUserByEmail(email);
    } catch (UserDoesNotExistsException e) {
      e.printStackTrace();
    }
    return entity;
  }
  
  
  @Transactional
  @DeleteMapping("api/users/{id}")
  public @ResponseBody String deleteUser(@PathVariable int id) {
    service.delete(id);
    return "Deleted";
  }

  @PutMapping("api/users/{id}")
  public @ResponseBody String updateUser(@PathVariable int id, @RequestBody UserEntity entity) {
    try {
      service.updateUser(id, entity);
    } catch (UserDoesNotExistsException e) {
      e.printStackTrace();
    }
    return "Updated";
  }

  /*@GetMapping("csrf")
  public CsrfToken getCsrfToken(CsrfToken token) {
      return token;
  }*/
}
