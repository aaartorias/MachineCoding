package main.java.com.services;

import main.java.com.persistence.UsersRepository;
import main.java.com.persistence.VehiclesRepository;
import main.java.com.exceptions.DriverNotFoundException;
import main.java.com.exceptions.VehicleAlreadyExistsException;
import main.java.com.models.User;
import main.java.com.models.Vehicle;

public class VehicleService {
    private VehiclesRepository vehiclesRepository;
    private UsersRepository usersRepository;

    public VehicleService(VehiclesRepository vehiclesRepository, UsersRepository usersRepository) {
        this.vehiclesRepository = vehiclesRepository;
        this.usersRepository = usersRepository;
    }

    public void addVehicle(String name, String model, String license)
            throws VehicleAlreadyExistsException, DriverNotFoundException {
        if (vehiclesRepository.vehicleExists(license)) {
            throw new VehicleAlreadyExistsException();
        }
        User owner = usersRepository.getUser(name);
        Vehicle vehicle = new Vehicle(owner, model, license);
        vehiclesRepository.addVehicle(vehicle);
    }
}
