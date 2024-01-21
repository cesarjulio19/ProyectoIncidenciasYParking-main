package com.alanturing.cpifp.incidentmanager.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Incident")
public class IncidentEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idInc;
    private String title;
    private String description;
    private LocalDate date;
    private boolean state;
    private String file;
    public int getIdInc() {
        return idInc;
    }
    public void setIdInc(int idInc) {
        this.idInc = idInc;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    
   


}
