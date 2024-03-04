package com.alanturing.cpifp.incidentmanager.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alanturing.cpifp.incidentmanager.core.incident.IncidentDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.core.user.UserDoesNotExistsException;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentDto;
import com.alanturing.cpifp.incidentmanager.domain.incidets.IncidentEntity;
import com.alanturing.cpifp.incidentmanager.service.incident.IncidentService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping("api/incidents") 
public class IncidentsController {

   
    private IncidentService service;

    
    public IncidentsController(IncidentService service) {
        this.service = service;
    }


    @GetMapping()
    public @ResponseBody Iterable<IncidentEntity> getAllIncidents() {

        return service.getAll();
    }

    @GetMapping("/{idInc}")
    public IncidentEntity getIncident(@PathVariable("idInc") int idInc) {
        IncidentEntity entity = new IncidentEntity();
        try {
            entity = service.getIncident(idInc);
        } catch (IncidentDoesNotExistsException e) {
            e.printStackTrace();
        }
        return entity;
    }
    

    @PostMapping()
    public @ResponseBody String addNewIncident(@RequestPart IncidentDto incident,
     @RequestParam MultipartFile file){
        try {
            InputStream imageInputStream = file.getInputStream();
            byte[] imageBytes = imageInputStream.readAllBytes();
            String contentType = file.getContentType();
            incident.setFile(imageBytes);
            incident.setFileType(contentType);
            service.addNewIncident(incident);  
            return "Saved";
        } catch (IOException e) {
            e.printStackTrace();
            return "Not saved";
        } catch (UserDoesNotExistsException e) {
            e.printStackTrace();
            return "Not saved";
        }

    }

    @PutMapping("/{idInc}")
    public @ResponseBody String updateIncident(@PathVariable("idInc") int idInc, @RequestPart IncidentDto incident, 
    @RequestParam MultipartFile file) {
        try {
            InputStream imageInputStream = file.getInputStream();
            byte[] imageBytes = imageInputStream.readAllBytes();
            String contentType = file.getContentType();
            incident.setFile(imageBytes);
            incident.setFileType(contentType);
            service.updateIncident(idInc, incident);
            return "Saved";
        } catch (IncidentDoesNotExistsException e) {
            e.printStackTrace();
            return "Not saved";
        } catch (IOException e) {
            e.printStackTrace();
            return "Not saved";
        }
        
    }

    @DeleteMapping("/{idInc}")
    public @ResponseBody String deleteIncident(@PathVariable int idInc) {
        service.deleteIncident(idInc);
        return "Deleted";
    }
}
