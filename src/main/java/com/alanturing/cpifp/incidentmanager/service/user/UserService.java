package com.alanturing.cpifp.incidentmanager.service.user;

import com.alanturing.cpifp.incidentmanager.core.user.UserAlreadyExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;

public interface UserService {

    public Iterable<UserEntity> getAll();

    public UserEntity getUser(int id) throws UserDoesNotExistsException;

    public UserEntity getUserByEmail(String email) throws UserDoesNotExistsException;

    public UserEntity addNewUser(UserEntity entity) throws UserAlreadyExistsException;

    public void delete(int id);

    public UserEntity updateUser(int id, UserEntity entity) throws UserDoesNotExistsException;
}
