package main.java.com.controllers;

import main.java.com.databases.*;
import main.java.com.exceptions.*;
import main.java.com.models.Ride;
import main.java.com.services.RideService;
import org.jetbrains.annotations.NotNull;

public class RidesController {
    private UsersManager usersManager;
    private PassengersManager passengersManager;
    private RidesManager ridesManager;
    private VehicleManager vehiclesManager;
    private DriversManager driversManager;
    private RideService rideService;


    public RidesController(RideService rideService) {
        this.rideService = rideService;
    }

    // Return RideId
    public void createRide(String name, String origin, int availableSeats
            ,String vehicleName, String vehicleLicense, String destination)
            throws VehicleNotFoundException, DriverNotFoundException, RiderAlreadyExistsException,
            RideAlreadyExistsForVehicleException, DriverAlreadyExistsException {
        rideService.createRide(name, origin, destination, vehicleLicense, availableSeats );
    }

    public void matchRide(String name, String origin
            ,String destination, int seatsRequested, String preferredVehicle)
            throws Exception {
        rideService.matchRide(name, origin, destination, seatsRequested, preferredVehicle);
    }

    public void matchRide(String name, String origin
            ,String destination, int seatsRequested)
            throws Exception {
        rideService.matchRide(name, origin, destination, seatsRequested);
    }

    public void startRide(@NotNull Ride ride) throws RideNotFoundException {
        rideService.startRide(ride.getId());
    }

    public void endRide(Integer rideId) throws Exception {
        rideService.endRide(rideId);
    }

    public void endAllRides() {
        //ridesManager.getRides().stream().forEach( x -> {
        rideService.endAllRides();
    }

    public void startRide(Integer rideId) throws RideNotFoundException {
        rideService.startRide(rideId);
    }
}
