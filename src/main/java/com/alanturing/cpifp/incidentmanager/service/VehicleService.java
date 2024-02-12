package com.alanturing.cpifp.incidentmanager.service;

import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleEntity;

public interface VehicleService {
    public Iterable<VehicleEntity> getAll();
    public String addVehicle(String model, String color, String licensePlate);
}
