package com.alanturing.cpifp.incidentmanager.service;

import com.alanturing.cpifp.incidentmanager.core.parking.RequestDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingEntity;

public interface ParkingService {
    public Iterable<ParkingEntity> getAll();
    public String createRequest(ParkingEntity entity);
    public String updateRequest(int id, ParkingEntity entity) throws RequestDoesNotExistsException;
    public String deleteRequest(int id);
}
