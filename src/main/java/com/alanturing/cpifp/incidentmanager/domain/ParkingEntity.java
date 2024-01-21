package com.alanturing.cpifp.incidentmanager.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "parking")
public class ParkingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdReq;
    private LocalDate date;
    private boolean state;

    public int getIdReq() {
        return IdReq;
    }
    public void setIdReq(int idReq) {
        IdReq = idReq;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
}
