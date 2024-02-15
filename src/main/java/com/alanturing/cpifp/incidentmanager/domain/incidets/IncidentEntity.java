package com.alanturing.cpifp.incidentmanager.domain.incidets;

import java.time.LocalDate;

import com.alanturing.cpifp.incidentmanager.domain.users.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity(name = "incidents")
public class IncidentEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idInc;
    private String title;
    private String description;
    private LocalDate date;
    private boolean state;
    @Lob
    @Column(name = "file", columnDefinition = "BLOB")
    private byte[] file;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    public IncidentEntity() {}
    public IncidentEntity(int idInc, String title, String description, LocalDate date, boolean state, byte[] file, UserEntity user) {
        this.idInc = idInc;
        this.title = title;
        this.description = description;
        this.date = date;
        this.state = state;
        this.file = file;
        this.user = user;
    }
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
    public byte[] getFile() {
        return file;
    }
    public void setFile(byte[] file) {
        this.file = file;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }

}
