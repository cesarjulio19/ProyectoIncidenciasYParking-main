package com.alanturing.cpifp.incidentmanager.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentDto;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentEntity;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentRepository;
import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;
import com.alanturing.cpifp.incidentmanager.domain.users.UserRepository;

@Service
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepository;
    private final UserRepository userRepository;

    public IncidentServiceImpl(IncidentRepository incidentRepository, UserRepository userRepository) {
        this.incidentRepository = incidentRepository;
        this.userRepository = userRepository;
    }

    public Iterable<IncidentEntity> getAll() {
        
        return incidentRepository.findAll();
        
    }

    @Override
    public String addNewIncident(IncidentDto incident) throws UserDoesNotExistsException {
        int userId = incident.getUserId();
        UserEntity user = this.userRepository.findById(userId).orElseThrow(() -> new UserDoesNotExistsException());
        IncidentEntity n = new IncidentEntity();
        BeanUtils.copyProperties(incident, n, "userId");
        n.setUser(user);
        n.setState(false);
        n.setDate(LocalDate.now());
        incidentRepository.save(n);
        return "Saved";

    }

    @Override
    public void deleteIncident(int idInc) {
        incidentRepository.deleteById(idInc);
    }
}
