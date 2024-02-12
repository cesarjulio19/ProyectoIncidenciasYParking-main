package com.alanturing.cpifp.incidentmanager.service;

import com.alanturing.cpifp.incidentmanager.core.user.UserAlreadyExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;

public interface UserService {

    public Iterable<UserEntity> getAll();

    public UserEntity getUser(int id) throws UserDoesNotExistsException;

    public UserEntity addNewUser(UserEntity entity) throws UserAlreadyExistsException;

    public void delete(int id);

    public String updateUser(int id, UserEntity entity) throws UserDoesNotExistsException;
}
