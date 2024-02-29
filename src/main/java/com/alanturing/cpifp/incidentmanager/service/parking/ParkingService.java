package com.alanturing.cpifp.incidentmanager.service.parking;

import com.alanturing.cpifp.incidentmanager.core.parking.RequestDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingDto;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingEntity;

public interface ParkingService {
    public Iterable<ParkingEntity> getAll();
    public ParkingEntity getRequest(int id) throws RequestDoesNotExistsException;
    public ParkingEntity createRequest(ParkingDto request) throws UserDoesNotExistsException;
    public ParkingEntity updateRequest(int id, ParkingDto request) throws RequestDoesNotExistsException;
    public void deleteRequest(int id);
}
