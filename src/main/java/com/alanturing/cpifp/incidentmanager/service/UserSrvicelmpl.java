package com.alanturing.cpifp.incidentmanager.service;



import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.core.user.UserAlreadyExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;
import com.alanturing.cpifp.incidentmanager.domain.users.UserRepository;

@Service
public class UserSrvicelmpl implements UserService {

  private final UserRepository userRepository;

  public UserSrvicelmpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Iterable<UserEntity> getAll() {
      return userRepository.findAll();
  }

  @Override
  public UserEntity addNewUser(UserEntity entity) throws UserAlreadyExistsException {
    return userRepository.save(entity);
  }

  @Override
  public void delete(int id) {
    userRepository.deleteById(id);
  }

  @Override
  public String updateUser(int id, UserEntity entity) throws UserDoesNotExistsException {
    UserEntity oldUser = userRepository.findById(id).orElseThrow(() -> new UserDoesNotExistsException());
    userRepository.save(entity);
    return "Updated";
  }

  @Override
  public UserEntity getUser(int id) throws UserDoesNotExistsException {
    UserEntity entity = userRepository.findById(id).orElseThrow(() -> new UserDoesNotExistsException());
    return entity;
  }
}
