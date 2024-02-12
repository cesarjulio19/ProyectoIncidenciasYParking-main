package com.alanturing.cpifp.incidentmanager.service;

import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleEntity;
import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;


    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

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
