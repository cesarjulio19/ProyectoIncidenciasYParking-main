package com.alanturing.cpifp.incidentmanager.controller;

import com.alanturing.cpifp.incidentmanager.domain.ParkingEntity;
import com.alanturing.cpifp.incidentmanager.service.ParkingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
    public @ResponseBody String addNewIncident(@RequestParam boolean state){

        service.createRequest(state);

        return "Saved";

    }

}
