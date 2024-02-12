package com.alanturing.cpifp.incidentmanager.domain.incidets;

public class IncidentDto {
    private int id;
    private String title;
    private String description;
    private boolean state;
    private String file;
    private int userId;
    
    public IncidentDto(String title, String description, String file, int userId, boolean state) {
        this.title = title;
        this.description = description;
        this.file = file;
        this.userId = userId;
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
