package main.java.com.controllers;

import main.java.com.database.*;
import main.java.com.exceptions.*;
import main.java.com.model.Ride;
import main.java.com.model.User;
import main.java.com.model.Vehicle;

public class RidesController {
    private UsersManager usersManager;
    private RidersManager ridersManager;
    private RidesManager ridesManager;
    private VehicleManager vehiclesManager;
    private DriversManager driversManager;

    public RidesController(UsersManager usersManager, RidersManager ridersManager,
                           RidesManager ridesManager, VehicleManager vehicleManager,
                           DriversManager driversManager) {
        this.usersManager = usersManager;
        this.ridersManager = ridersManager;
        this.ridesManager = ridesManager;
        this.vehiclesManager = vehicleManager;
        this.driversManager = driversManager;
    }

    public void createRide(String name, String origin, int availableSeats
            ,String vehicleName, String vehicleLicense, String destination)
            throws VehicleNotFoundException, DriverNotFoundException, RiderAlreadyExistsException,
            RideAlreadyExistsForDriverException, DriverAlreadyExistsException {

        if (driversManager.driverExists(name)) {
            throw new RideAlreadyExistsForDriverException();
        }
        User driver =  usersManager.getUser(name);
        Vehicle vehicle = vehiclesManager.getVehicle(vehicleLicense);
        Ride ride = new Ride(origin, destination, driver,vehicle, availableSeats);
        ridesManager.addRide(ride);
        driversManager.addDriver(driver);
        driver.addRidesOffered();
    }

    public void selectRide(String name, String origin
            ,String destination, int seatsRequested, String preferredVehicle)
            throws RiderAlreadyExistsException, RideNotAvailableException,
            NoRidesAvailableException, DriverNotFoundException {

        if (ridersManager.riderExists(name)) {
            throw new RiderAlreadyExistsException();
        }
        Ride match = null;
        for(Ride ride : ridesManager.getAvailableRides()) {
            if (ride.getSource() == origin && ride.getDestination() == destination
                    && ride.getAvailableSeats() >= seatsRequested) {
                if (match == null) {
                    match = ride;
                } else if (match.getVehicle().getModel() == preferredVehicle) {
                    match = ride;
                }
            }
        }
        if (match == null) {
            throw new NoRidesAvailableException();
        }
        User rider = usersManager.getUser(name); // handle exception
        match.reserveSeats(seatsRequested);
        rider.addRidesTaken();
        ridersManager.addRider(rider);
    }

    public void selectRide(String name, String origin
            ,String destination, int seatsRequested)
            throws NoRidesAvailableException, DriverNotFoundException, RiderAlreadyExistsException
            ,RideNotAvailableException {

        if (ridersManager.riderExists(name)) {
            throw new RiderAlreadyExistsException();
        }
        Ride match = null;
        for(Ride ride : ridesManager.getAvailableRides()) {
            if (ride.getSource() == origin && ride.getDestination() == destination
                    && ride.getAvailableSeats() >= seatsRequested) {
                if (match == null) {
                    match = ride;
                } else if (match.getAvailableSeats() < ride.getAvailableSeats() ){
                    match = ride;
                }
            }
        }
        if (match == null) {
            throw new NoRidesAvailableException();
        }
        User rider = usersManager.getUser(name); // handle exception
        match.reserveSeats(seatsRequested);
        rider.addRidesTaken();
        ridersManager.addRider(rider);

        if (match.getAvailableSeats() == 0) startRide(match);
    }

    public void startRide(Ride ride) {
        ride.startTrip();
    }

    public void endRide(Ride ride) {
        ride.endTrip();
        ridersManager.removeRiders(ride.getRiders());
    }

}
