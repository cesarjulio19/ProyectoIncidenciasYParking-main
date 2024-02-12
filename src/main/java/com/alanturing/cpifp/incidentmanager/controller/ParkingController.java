package com.alanturing.cpifp.incidentmanager.controller;

import com.alanturing.cpifp.incidentmanager.core.parking.RequestDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingEntity;
import com.alanturing.cpifp.incidentmanager.service.ParkingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
@RequestMapping("api/parking-requests")
public class ParkingController {
    private ParkingService service;

    private ParkingController(ParkingService service) {
        this.service = service;
    }

    @GetMapping()
    public @ResponseBody Iterable<ParkingEntity> getAllParkingRequests() {
        return service.getAll();
    }
    
    @PostMapping()
    public @ResponseBody String addParkingRequest(@RequestBody ParkingEntity entity){

        service.createRequest(entity);

        return "Saved";

    }

    @PutMapping("/{id}")
    public String updateParkingRequest(@PathVariable int id, @RequestBody ParkingEntity entity) {
        try {
            service.updateRequest(id, entity);
        } catch (RequestDoesNotExistsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteParkingRequest(@PathVariable int id) {
        service.deleteRequest(id);
        return "Deleted";
    }
}
