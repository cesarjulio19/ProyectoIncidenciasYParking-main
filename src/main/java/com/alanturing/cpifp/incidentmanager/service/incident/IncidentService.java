package com.alanturing.cpifp.incidentmanager.service.incident;

import com.alanturing.cpifp.incidentmanager.core.incident.IncidentDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentDto;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentEntity;

public interface IncidentService {
    
    public Iterable<IncidentEntity> getAll();

    public IncidentEntity addNewIncident(IncidentDto incident) throws UserDoesNotExistsException;

    public void deleteIncident(int idInc);

    public IncidentEntity updateIncident(int idInc, IncidentDto incident) throws IncidentDoesNotExistsException;
}
