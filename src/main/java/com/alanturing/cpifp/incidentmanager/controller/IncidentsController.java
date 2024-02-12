package com.alanturing.cpifp.incidentmanager.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentDto;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentEntity;
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
    public @ResponseBody String addNewIncident(@RequestBody IncidentDto incident){

        try {
            service.addNewIncident(incident);
        } catch (UserDoesNotExistsException e) {
            e.printStackTrace();
        }

        return "Saved";

    }

    @DeleteMapping("/{idInc}")
    public void deleteIncident(@PathVariable int idInc) {
        service.deleteIncident(idInc);
    }
}
