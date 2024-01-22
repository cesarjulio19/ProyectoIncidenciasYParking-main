package com.alanturing.cpifp.incidentmanager.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alanturing.cpifp.incidentmanager.domain.IncidentEntity;
import com.alanturing.cpifp.incidentmanager.domain.IncidentRepository;


@Service
public class IncidentServiceImpl implements IncidentService {

  @Autowired 
  private IncidentRepository incidentRepository;

    public Iterable<IncidentEntity> getAll() {
        
        return incidentRepository.findAll();
        
    }

    @Override
    public String addNewIncident(String title, String description, String file ){

        IncidentEntity n = new IncidentEntity(title, description, LocalDate.now(), false, file);
        incidentRepository.save(n);
        return "Saved";

    }
}
