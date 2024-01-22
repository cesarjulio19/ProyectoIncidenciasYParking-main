package com.alanturing.cpifp.incidentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.domain.VehicleEntity;
import com.alanturing.cpifp.incidentmanager.domain.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository repository;


    @Override
    public Iterable<VehicleEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public String addVehicle(String model, String color, String licensePlate) {
        VehicleEntity vehicle = new VehicleEntity(model, color, licensePlate);
        repository.save(vehicle);
        return "Saved";
    }
    
}
