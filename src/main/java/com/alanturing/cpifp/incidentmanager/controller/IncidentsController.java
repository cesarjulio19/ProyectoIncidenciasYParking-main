package com.alanturing.cpifp.incidentmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alanturing.cpifp.incidentmanager.domain.IncidentEntity;
import com.alanturing.cpifp.incidentmanager.service.IncidentService;

@RestController 
@RequestMapping("api/incidents") 
public class IncidentsController {

   
    private IncidentService service;

    
    public IncidentsController(IncidentService service) {
        this.service = service;
    }


    @GetMapping()
    public @ResponseBody Iterable<IncidentEntity> getAllIncidents() {

        return service.getAll();
    }

    @PostMapping()
    public @ResponseBody String addNewIncident(@RequestParam String title,
     @RequestParam String description, @RequestParam String file){

        service.addNewIncident(title, description, file);

        return "Saved";

    }
}
