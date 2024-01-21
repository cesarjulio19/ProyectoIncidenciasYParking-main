package com.alanturing.cpifp.incidentmanager.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addNewIncident(@RequestParam String title,
     @RequestParam String description, @RequestParam String file ){

        IncidentEntity n = new IncidentEntity();

        n.setTitle(title);
        n.setDescription(description);
        n.setFile(file);
        n.setState(false);
        n.setDate(LocalDate.now());
        incidentRepository.save(n);
        return "Saved";

    }


    
}
