package main.Model;

public class Vehicle {
    private String license;
    private Size size;
    private String color;

    public Vehicle(Size Size, String license, String color) {
        this.size = size;
        this.license = license;
        this.color = color;
    }

    public String getLicense() {
        return license;
    }

    public Size getVehicleType() {
        return size;
    }


}
