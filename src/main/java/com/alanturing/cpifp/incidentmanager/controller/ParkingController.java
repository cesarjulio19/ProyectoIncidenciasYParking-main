package com.alanturing.cpifp.incidentmanager.controller;

import com.alanturing.cpifp.incidentmanager.core.parking.RequestDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingDto;
import com.alanturing.cpifp.incidentmanager.domain.parking.ParkingEntity;
import com.alanturing.cpifp.incidentmanager.service.parking.ParkingService;

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
@RequestMapping("api/parking_requests")
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
    public @ResponseBody String addParkingRequest(@RequestBody ParkingDto request){

        try {
            service.createRequest(request);
            return "Saved";
        } catch (UserDoesNotExistsException e) {
            e.printStackTrace();
            return "Not saved";
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ParkingEntity getParkingRequest(@PathVariable("id") int id) {
        ParkingEntity request = new ParkingEntity();
        try {
            request = service.getRequest(id);
        } catch (RequestDoesNotExistsException e) {
            e.printStackTrace();
        }
        return request;
    }

    @PutMapping("/{id}")
    public @ResponseBody String updateParkingRequest(@PathVariable int id, @RequestBody ParkingDto request) {
        try {
            service.updateRequest(id, request);
            return "Updated";
        } catch (RequestDoesNotExistsException e) {
            e.printStackTrace();
            return "Not Saved";
        }
    }

    @DeleteMapping("/{idReq}")
    public @ResponseBody String deleteParkingRequest(@PathVariable int idReq) {
        service.deleteRequest(idReq);
        return "Deleted";
    }
}
