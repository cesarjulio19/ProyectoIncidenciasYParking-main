package com.alanturing.cpifp.incidentmanager.domain.parking;

public class ParkingDto {
    private int id;
    private boolean state;
    private int user_id;

    public ParkingDto(int id, boolean state, int user_id) {
        this.id = id;
        this.state = state;
        this.user_id = user_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
}
