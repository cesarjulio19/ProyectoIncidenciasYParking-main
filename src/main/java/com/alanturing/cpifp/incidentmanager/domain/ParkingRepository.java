package com.alanturing.cpifp.incidentmanager.domain;

import org.springframework.data.repository.CrudRepository;

public interface ParkingRepository extends CrudRepository<ParkingEntity,Integer> {
    
}
