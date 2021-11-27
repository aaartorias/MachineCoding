package main.java.com.models;

import main.java.com.interfaces.IVehicle;

public class Vehicle implements IVehicle {
    private String model;
    private String license;
    private User owner;

    public Vehicle(User owner, String model, String license) {
        this.owner = owner;
        this.model = model;
        this.license = license;
    }

    public User getOwner() {
        return owner;
    }

    public String getLicense() {
        return license;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}