package com.alanturing.cpifp.incidentmanager.service;

import com.alanturing.cpifp.incidentmanager.domain.ParkingEntity;

public interface ParkingService {
    public Iterable<ParkingEntity> getAll();
    public String createRequest(boolean state);
}
