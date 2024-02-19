package com.alanturing.cpifp.incidentmanager.domain.incidets;

public class IncidentDto {
    private int id;
    private String title;
    private String description;
    private boolean state;
    private byte[] file;
    private String fileType;
    private int userId;
    
    public IncidentDto(String title, String description, byte[] file, String fileType, int userId, boolean state) {
        this.title = title;
        this.description = description;
        this.file = file;
        this.userId = userId;
        this.state = state;
        this.fileType = fileType;
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
    public byte[] getFile() {
        return file;
    }
    public void setFile(byte[] file) {
        this.file = file;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
