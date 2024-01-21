package com.alanturing.cpifp.incidentmanager.service;

import java.util.List;

import com.alanturing.cpifp.incidentmanager.domain.IncidentEntity;

public interface IncidentService {
    
    public List<IncidentEntity> getAll();
}
