package com.alanturing.cpifp.incidentmanager.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idUsu;
    private String name;
    private String surname;
    @Nonnull
    @Column(unique = true)
    private String nif;
    @Nonnull
    @Column(unique = true)
    private String email;
    private String password;
    private int postalCode;
    private String address;
    private String rol;
    private String schoolYear;
    private boolean parkingAccess;

    public UserEntity(String name, String surname, String nif, String email, String password, int postalCode,
            String address, String rol, String schoolYear, boolean parkingAccess) {
        this.name = name;
        this.surname = surname;
        this.nif = nif;
        this.email = email;
        this.password = password;
        this.postalCode = postalCode;
        this.address = address;
        this.rol = rol;
        this.schoolYear = schoolYear;
        this.parkingAccess = parkingAccess;
    }

    public boolean hasParkingAccess() {
        return parkingAccess;
    }
    public void setParkingAccess(boolean parkingAccess) {
        this.parkingAccess = parkingAccess;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    } 
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSchoolYear() {
        return schoolYear;
    }
    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }
}

