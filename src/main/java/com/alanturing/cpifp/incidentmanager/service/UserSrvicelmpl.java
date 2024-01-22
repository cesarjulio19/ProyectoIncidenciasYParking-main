package com.alanturing.cpifp.incidentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.core.UserAlreadyExistsException;
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
  public String addNewUser(String name, String email, String surname,
  String password, String address, int postalCode, String nif, String schoolYear) throws UserAlreadyExistsException {
      
    UserEntity n = new UserEntity(name, surname, nif, email, password, postalCode,
    address, "User", schoolYear, false);
    if (userRepository.existsByEmail(email)) {
      throw new UserAlreadyExistsException();
    }

    userRepository.save(n);
    return "Saved";
  }

  @Override
  public void delete(int id) {
    userRepository.deleteById(id);
  }

  @Override
  public String updateUser(int id, UserEntity entity) {
    UserEntity oldUser = userRepository.findById(id).orElseThrow();
    userRepository.save(entity);
    return "Updated";
  }
}
