package com.alanturing.cpifp.incidentmanager.service.vehicle;

import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.core.vehicle.VehicleDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleDto;
import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleEntity;

public interface VehicleService {
    public Iterable<VehicleEntity> getAll();
    public VehicleEntity getVehicle(int idV) throws VehicleDoesNotExistsException;
    public VehicleEntity addVehicle(VehicleDto vehicleDto) throws UserDoesNotExistsException;
    public VehicleEntity updateVehicle(int id, VehicleDto vehicleDto) throws VehicleDoesNotExistsException;
    public void deleteVehicle(int id);
}
