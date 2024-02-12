package com.alanturing.cpifp.incidentmanager.domain.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "vehicles")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idV;
    private String model;
    private String color;
    private String licensePlate;
    public VehicleEntity(String model, String color, String licensePlate) {
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
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
}
