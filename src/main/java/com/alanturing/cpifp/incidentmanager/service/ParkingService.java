package com.alanturing.cpifp.incidentmanager.service;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestParam;

import com.alanturing.cpifp.incidentmanager.domain.ParkingEntity;

public interface ParkingService {
    public Iterable<ParkingEntity> getAll();
    public String createRequest(@RequestParam LocalDate date, @RequestParam boolean state);
}
