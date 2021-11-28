package main.interfaces.repository;

import main.models.vehicles.Vehicle;
import main.models.VehicleType;

public interface IVehicleRepository {
    Vehicle addVehicle(VehicleType vehicleType, String license, String color);
    Vehicle getVehicle(String license);
}
