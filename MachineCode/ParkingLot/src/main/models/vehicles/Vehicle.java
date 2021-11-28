package main.models.vehicles;

public class Vehicle {
    private String license;
    private String color;

    public Vehicle(String license, String color) {
        this.license = license;
        this.color = color;
    }

    public String getLicense() {
        return license;
    }

    public String getVehicleColor() {
        return color;
    }


}
