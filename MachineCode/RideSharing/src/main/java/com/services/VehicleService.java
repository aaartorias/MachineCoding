package main.java.com.services;

import main.java.com.databases.UsersManager;
import main.java.com.databases.VehicleManager;
import main.java.com.exceptions.DriverNotFoundException;
import main.java.com.exceptions.VehicleAlreadyExistsException;
import main.java.com.models.User;
import main.java.com.models.Vehicle;

public class VehicleService {
    private VehicleManager vehicleManager;
    private UsersManager usersManager;

    public VehicleService(VehicleManager vehicleManager, UsersManager usersManager) {
        this.vehicleManager = vehicleManager;
        this.usersManager = usersManager;
    }

    public void addVehicle(String name, String model, String license)
            throws VehicleAlreadyExistsException, DriverNotFoundException {
        if (vehicleManager.vehicleExists(license)) {
            throw new VehicleAlreadyExistsException();
        }
        User owner = usersManager.getUser(name);
        Vehicle vehicle = new Vehicle(owner, model, license);
        vehicleManager.addVehicle(vehicle);
    }
}
