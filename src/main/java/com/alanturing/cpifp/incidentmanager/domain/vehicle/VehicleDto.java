package com.alanturing.cpifp.incidentmanager.domain.vehicle;

public class VehicleDto {
    private int idV;
    private String model;
    private String color;
    private String licensePlate;
    private int user_id;

    public VehicleDto(int idV, String model, String color, String licensePlate, int user_id) {
        this.idV = idV;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
        this.user_id = user_id;
    }

    public int getIdV() {
        return idV;
    }
    public void setIdV(int idV) {
        this.idV = idV;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
