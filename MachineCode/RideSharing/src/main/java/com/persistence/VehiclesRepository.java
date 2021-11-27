package main.java.com.persistence;

import main.java.com.exceptions.VehicleAlreadyExistsException;
import main.java.com.exceptions.VehicleNotFoundException;
import main.java.com.models.Vehicle;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class VehiclesRepository {
    private HashMap<String, Vehicle> vehicles;

    public VehiclesRepository() {
        vehicles = new HashMap<>();
    }

    public void addVehicle(@NotNull Vehicle vehicle) throws VehicleAlreadyExistsException {
        if (vehicles.containsKey(vehicle.getLicense())) {
            throw new VehicleAlreadyExistsException();
        }
        vehicles.put(vehicle.getLicense(),vehicle);
    }

    public Vehicle getVehicle(String license) throws VehicleNotFoundException {
        if (!vehicles.containsKey(license)) {
            throw new VehicleNotFoundException();
        }
        return vehicles.get(license);
    }

    public boolean vehicleExists(String license) {
        if (vehicles.containsKey(license)) {
            return true;
        }
        return false;
    }

    public boolean hasVehicle(String vehicleLicense) {
        if (vehicles.containsKey(vehicleLicense))
            return true;
        return false;
    }
}
