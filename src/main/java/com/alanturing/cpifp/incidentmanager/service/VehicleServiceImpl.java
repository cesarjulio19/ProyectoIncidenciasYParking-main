package com.alanturing.cpifp.incidentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addVehicle(@RequestParam String model, @RequestParam String color, @RequestParam String licensePlate) {
        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setColor(color);
        vehicle.setModel(model);
        vehicle.setLicensePlate(licensePlate);
        repository.save(vehicle);
        return "Saved";
    }
    
}
