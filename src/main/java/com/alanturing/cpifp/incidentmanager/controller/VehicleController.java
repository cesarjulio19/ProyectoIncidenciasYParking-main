package com.alanturing.cpifp.incidentmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.core.vehicle.VehicleDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;
import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleDto;
import com.alanturing.cpifp.incidentmanager.domain.vehicle.VehicleEntity;
import com.alanturing.cpifp.incidentmanager.service.vehicle.VehicleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


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

    @GetMapping("/{id}")
    public @ResponseBody VehicleEntity getVehicleByUser(@PathVariable("id") int id) {
        VehicleEntity vehicle = new VehicleEntity();
        try {
            vehicle = service.getVehicle(id);
        } catch (VehicleDoesNotExistsException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @PostMapping()
    public @ResponseBody String addVehicle(@RequestBody VehicleDto vehicleDto){
        try {
            service.addVehicle(vehicleDto);
            return "Saved";
        } catch (UserDoesNotExistsException e) {
            e.printStackTrace();
            return "Not saved";
        }
    }
    
    @PutMapping("/{id}")
    public @ResponseBody String updateVehicle(@PathVariable int id, @RequestBody VehicleDto vehicleDto) {
        try {
            service.updateVehicle(id, vehicleDto);
            return "Saved";
        } catch (VehicleDoesNotExistsException e) {
            e.printStackTrace();
            return "Not saved";
        }
    }

    @DeleteMapping("/{id}")
    private @ResponseBody String deleteVehicle(@PathVariable int id) {
        service.deleteVehicle(id);
        return "Deleted";
    }
}
