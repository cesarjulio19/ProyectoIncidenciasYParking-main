package com.alanturing.cpifp.incidentmanager.service;


import org.springframework.web.bind.annotation.RequestParam;

import com.alanturing.cpifp.incidentmanager.domain.IncidentEntity;

public interface IncidentService {
    
    public Iterable<IncidentEntity> getAll();

    public String addNewIncident(@RequestParam String title, @RequestParam String description
    , @RequestParam String file);

}
