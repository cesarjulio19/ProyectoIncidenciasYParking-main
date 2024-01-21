package com.alanturing.cpifp.incidentmanager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alanturing.cpifp.incidentmanager.domain.IncidentEntity;
import com.alanturing.cpifp.incidentmanager.service.IncidentService;

@Controller 
@RequestMapping("api/incident") 
public class IncidentsController {

   
    private IncidentService service;

    
    public IncidentsController(IncidentService service) {
        this.service = service;
    }


    @GetMapping("api/incident")
    public @ResponseBody Iterable<IncidentEntity> getAllIncidents() {

        return service.getAll();
    }

    @GetMapping("api/incident")
    public String addNewIncident(@RequestParam String title,
     @RequestParam String description, @RequestParam String file){

        service.addNewIncident(title, description, file);

        return "Saved";

    }
   
    

}
