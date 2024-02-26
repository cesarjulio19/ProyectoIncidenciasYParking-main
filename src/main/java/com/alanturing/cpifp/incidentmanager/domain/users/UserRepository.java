package com.alanturing.cpifp.incidentmanager.domain.users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    public Optional<UserEntity> findByEmail(String email);
    public boolean existsByEmail(String email);
}
