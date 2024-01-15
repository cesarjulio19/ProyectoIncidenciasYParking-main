package com.alanturing.cpifp.incidentmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.domain.Incident;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Override
    public List<Incident> getAll() {
        List<Incident> incidents = new ArrayList<>();
        incidents.add(new Incident(1, "Pomo Roto"));
        incidents.add(new Incident(2, "Internet infernal"));

        return  incidents;
    }
    
}
