package com.alanturing.cpifp.incidentmanager.service;

import com.alanturing.cpifp.incidentmanager.core.UserAlreadyExistsException;
import com.alanturing.cpifp.incidentmanager.domain.UserEntity;

public interface UserService {

    public Iterable<UserEntity> getAll();

    public String addNewUser(String name, String email, String surname,
    String password, String address, int postalCode, String nif, String schoolYear) throws UserAlreadyExistsException;

    public void delete(int id);

    public String updateUser(int id, UserEntity entity);
}
