package Model;

enum VehicleType {
    CAR,
    BIKE,
    TRUCK
}

public class Vehicle {
    private String license;
    private VehicleType vehicleType;

    public Vehicle(String license, VehicleType vehicleType) {
        this.license = license;
        this.vehicleType = vehicleType;
    }

    public String getLicense() {
        return license;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


}
