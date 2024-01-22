package com.alanturing.cpifp.incidentmanager.service;

import com.alanturing.cpifp.incidentmanager.domain.IncidentEntity;

public interface IncidentService {
    
    public Iterable<IncidentEntity> getAll();

    public String addNewIncident(String title, String description, String file);

}
