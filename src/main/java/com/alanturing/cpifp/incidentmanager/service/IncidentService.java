package com.alanturing.cpifp.incidentmanager.service;

import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentDto;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentEntity;

public interface IncidentService {
    
    public Iterable<IncidentEntity> getAll();

    public String addNewIncident(IncidentDto incident) throws UserDoesNotExistsException;

    public void deleteIncident(int idInc);
}
