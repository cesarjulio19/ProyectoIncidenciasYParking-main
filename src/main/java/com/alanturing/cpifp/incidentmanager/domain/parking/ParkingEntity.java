package com.alanturing.cpifp.incidentmanager.domain.parking;

import java.time.LocalDate;

import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "parking_requests")
public class ParkingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReq;
    private LocalDate date;
    private boolean state;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public ParkingEntity(){}
    public ParkingEntity(LocalDate date, boolean state) {
        this.date = date;
        this.state = state;
    }
    public int getIdReq() {
        return idReq;
    }
    public void setIdReq(int idReq) {
        this.idReq = idReq;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
}
