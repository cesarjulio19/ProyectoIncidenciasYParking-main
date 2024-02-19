package com.alanturing.cpifp.incidentmanager.domain.users;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    public Iterable<UserEntity> findByEmail(String email);
    public boolean existsByEmail(String email);
}
