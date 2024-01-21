package com.alanturing.cpifp.incidentmanager.domain;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    
}
