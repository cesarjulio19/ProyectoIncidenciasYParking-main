package com.alanturing.cpifp.incidentmanager.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.core.parking.RequestDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingEntity;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingRepository;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository repository;

    public ParkingServiceImpl(ParkingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<ParkingEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public String createRequest(ParkingEntity entity) {
        ParkingEntity request = new ParkingEntity(LocalDate.now(), false);
        repository.save(request);
        return "Saved";
    }

    @Override
    public String updateRequest(int id, ParkingEntity entity) throws RequestDoesNotExistsException {
        ParkingEntity oldRequest = repository.findById(id).orElseThrow(() -> new RequestDoesNotExistsException());
        if(oldRequest.getIdReq() == id) {
            repository.save(entity);
        }
        return "Updated";
    }

    @Override
    public String deleteRequest(int id) {
        repository.deleteById(id);
        return "Deleted";
    }
}
