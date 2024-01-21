package com.alanturing.cpifp.incidentmanager.domain;

public class IncidentEntity {
    private int id;
    private String description;
    public IncidentEntity(int id, String description) {
        this.id = id;
        this.description = description;
    }
    public void setDescription(String description) {
    this.description = description;
   }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }


}
