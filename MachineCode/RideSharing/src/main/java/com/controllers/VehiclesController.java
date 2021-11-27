package main.java.com.controllers;

import main.java.com.persistence.UsersRepository;
import main.java.com.persistence.VehiclesRepository;
import main.java.com.exceptions.DriverNotFoundException;
import main.java.com.exceptions.VehicleAlreadyExistsException;
import main.java.com.services.VehicleService;

public class VehiclesController {
    private VehiclesRepository vehiclesRepository;
    private UsersRepository usersRepository;
    private VehicleService vehicleService;


    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void registerVehicle(String name, String model, String license)
            throws VehicleAlreadyExistsException, DriverNotFoundException {
        vehicleService.addVehicle(name, model, license);
    }

}
