package com.alanturing.cpifp.incidentmanager.service.incident;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alanturing.cpifp.incidentmanager.core.incident.IncidentDoesNotExistsException;
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
    public IncidentEntity addNewIncident(IncidentDto incident) throws UserDoesNotExistsException {
        int userId = incident.getUserId();
        UserEntity user = this.userRepository.findById(userId).orElseThrow(() -> new UserDoesNotExistsException());
        IncidentEntity n = new IncidentEntity();
        BeanUtils.copyProperties(incident, n, "userId");
        n.setUser(user);
        n.setDate(LocalDate.now());
        n.setState(false);
        return incidentRepository.save(n);
    }

    @Override
    public void deleteIncident(int idInc) {
        incidentRepository.deleteById(idInc);
    }

    @Override
    public IncidentEntity updateIncident(int idInc, IncidentDto incident) throws IncidentDoesNotExistsException {
        IncidentEntity incidentDB = this.incidentRepository.findById(idInc).orElseThrow(() -> new IncidentDoesNotExistsException());
        incidentDB.setDescription(incident.getDescription());
        incidentDB.setTitle(incident.getTitle());
        //incidentDB.setFile(incident.getFile());
        incidentDB.setState(incident.getState());
        return incidentRepository.save(incidentDB);
    }

    @Override
    public IncidentEntity getIncident(int idInc) throws IncidentDoesNotExistsException {
        return incidentRepository.findById(idInc).orElseThrow(() -> new IncidentDoesNotExistsException());
    }
}
