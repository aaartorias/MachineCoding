package main.java.com.model;

public class Vehicle {
    private String model;
    private String license;
    private User owner;

    public Vehicle(User owner, String model, String license) {
        this.owner = owner;
        this.model = model;
        this.license = license;
    }

    private User getUser() {
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