package com.alanturing.cpifp.incidentmanager.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.alanturing.cpifp.incidentmanager.domain.VehicleEntity;

public interface VehicleService {
    public Iterable<VehicleEntity> getAll();
    public String addVehicle(@RequestParam String model, @RequestParam String color, @RequestParam String licensePlate);
}
