package com.alanturing.cpifp.incidentmanager.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alanturing.cpifp.incidentmanager.domain.Incident;
import com.alanturing.cpifp.incidentmanager.service.IncidentService;

@RestController
public class IncidentsController {

   
    private IncidentService service;


    public IncidentsController(IncidentService service) {
        this.service = service;
    }


    @GetMapping("incidents")
    public List<Incident> getAllIncidents() {

        return service.getAll();
    }
   
    

}
