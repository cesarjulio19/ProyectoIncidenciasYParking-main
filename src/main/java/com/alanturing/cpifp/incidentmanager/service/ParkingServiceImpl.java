package com.alanturing.cpifp.incidentmanager.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.domain.ParkingEntity;
import com.alanturing.cpifp.incidentmanager.domain.ParkingRepository;

@Service
public class ParkingServiceImpl implements ParkingService {

    private ParkingRepository repository;

    @Override
    public Iterable<ParkingEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public String createRequest(boolean state) {
        ParkingEntity request = new ParkingEntity(LocalDate.now(), state);
        repository.save(request);
        return "Saved";
    }
}
