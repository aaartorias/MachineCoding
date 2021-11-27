package main.java.com.controllers;

import main.java.com.databases.UsersManager;
import main.java.com.databases.VehicleManager;
import main.java.com.exceptions.DriverNotFoundException;
import main.java.com.exceptions.VehicleAlreadyExistsException;
import main.java.com.models.User;
import main.java.com.models.Vehicle;
import main.java.com.services.VehicleService;

public class VehiclesController {
    private VehicleManager vehicleManager;
    private UsersManager usersManager;
    private VehicleService vehicleService;


    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void registerVehicle(String name, String model, String license)
            throws VehicleAlreadyExistsException, DriverNotFoundException {
        vehicleService.addVehicle(name, model, license);
    }

}
