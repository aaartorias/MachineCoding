package main.java.com.controllers;

import main.java.com.database.DriversManager;
import main.java.com.database.UsersManager;
import main.java.com.database.VehicleManager;
import main.java.com.database.RidersManager;
import main.java.com.exceptions.DriverNotFoundException;
import main.java.com.exceptions.VehicleAlreadyExistsException;
import main.java.com.model.User;
import main.java.com.model.Vehicle;

public class VehiclesController {
    private VehicleManager vehicleManager;
    private RidersManager ridersManager;
    private DriversManager driversManager;
    private UsersManager usersManager;


    public VehiclesController(VehicleManager vehicleManager, RidersManager ridersManager, UsersManager usersManager) {
        this.vehicleManager = vehicleManager;
        this.ridersManager = ridersManager;
        this.driversManager = driversManager;
        this.usersManager = usersManager;
    }

    public void registerVehicle(String name, String model, String license)
            throws VehicleAlreadyExistsException, DriverNotFoundException {
        if (vehicleManager.vehicleExists(license)) {
            throw new VehicleAlreadyExistsException();
        }
        User owner = usersManager.getUser(name);
        Vehicle vehicle = new Vehicle(owner, model, license);
        vehicleManager.addVehicle(vehicle);
    }

}
