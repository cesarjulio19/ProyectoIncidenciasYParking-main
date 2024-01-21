package com.alanturing.cpifp.incidentmanager.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.alanturing.cpifp.incidentmanager.domain.ParkingEntity;
import com.alanturing.cpifp.incidentmanager.domain.ParkingRepository;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepository repository;

    @Override
    public Iterable<ParkingEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public String createRequest(@RequestParam LocalDate date, @RequestParam boolean state) {
        ParkingEntity request = new ParkingEntity();
        request.setDate(date);
        request.setState(state);
        repository.save(request);
        return "Saved";
    }
}
