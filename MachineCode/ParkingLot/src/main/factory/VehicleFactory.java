package main.factory;

import main.models.VehicleType;
import main.models.vehicles.Bike;
import main.models.vehicles.Car;
import main.models.vehicles.Truck;
import main.models.vehicles.Vehicle;

public class VehicleFactory {

    public Vehicle createVehicle(VehicleType vehicleType, String license, String color) {
        Vehicle vehicle = null;
        if (vehicleType == VehicleType.BIKE) {
            vehicle = new Bike(license, color);
        } else if (vehicleType == VehicleType.CAR) {
            vehicle = new Car(license, color);
        } else if (vehicleType == VehicleType.TRUCK) {
            vehicle = new Truck(license, color);
        } else {
            throw new IllegalArgumentException("Illegal Vehicle type : " + vehicleType );
        }
        return vehicle;
    }
}
