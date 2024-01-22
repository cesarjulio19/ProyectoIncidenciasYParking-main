package com.alanturing.cpifp.incidentmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alanturing.cpifp.incidentmanager.domain.VehicleEntity;
import com.alanturing.cpifp.incidentmanager.service.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("api/vehicles")
public class VehicleController {
    private VehicleService service;

    public VehicleController (VehicleService service) {
        this.service = service;
    }

    @GetMapping()
    public @ResponseBody Iterable<VehicleEntity> getAllVehicles() {
        return service.getAll();
    }

    @PostMapping()
    public @ResponseBody String addVehicle(@RequestParam String model,
     @RequestParam String color, @RequestParam String licensePlate){
        service.addVehicle(model, color, licensePlate);
        return "Saved";
    } 
}
