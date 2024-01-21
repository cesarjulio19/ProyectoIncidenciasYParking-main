package com.alanturing.cpifp.incidentmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.domain.IncidentEntity;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Override
    public List<IncidentEntity> getAll() {
        List<IncidentEntity> incidents = new ArrayList<>();
        incidents.add(new IncidentEntity(1, "Pomo Roto"));
        incidents.add(new IncidentEntity(2, "Internet infernal"));

        return  incidents;
    }
    
}
