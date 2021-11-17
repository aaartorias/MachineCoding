package main.java.com.controllers;

import main.java.com.database.*;
import main.java.com.exceptions.*;
import main.java.com.models.Ride;
import main.java.com.models.User;
import main.java.com.models.Vehicle;

import java.util.ArrayList;

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
            RideAlreadyExistsForVehicleException, DriverAlreadyExistsException {

        // need to find ride for the vehicle
        User driver =  usersManager.getUser(name);
        if (ridesManager.hasRideForVehicle(vehicleLicense)) {
            throw new RideAlreadyExistsForVehicleException();
        }
        Vehicle vehicle = vehiclesManager.getVehicle(vehicleLicense);
        Ride ride = new Ride(origin, destination, driver,vehicle, availableSeats);
        ridesManager.addRide(ride);
        try {
            driversManager.addDriver(driver);
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.addRidesOffered();
    }

    public void matchRide(String name, String origin
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

    public void matchRide(String name, String origin
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

    public void endRide(Integer rideId) throws NoRidersFound, RideNotFoundException {
        Ride ride = ridesManager.getRide(rideId);
        ride.endTrip();
        ArrayList<User> riders = ride.getRiders();
        if (riders == null) {
            throw new NoRidersFound();
        }
        ridersManager.removeRiders(riders);
    }

    public void endAllRides() {
        //ridesManager.getRides().stream().forEach( x -> {
        try {
            for (Integer ride : ridesManager.getRides()) {
                endRide(ride);
            }
        } catch (RideNotFoundException | NoRidersFound e) {
            System.out.println(e);
            //.printStackTrace()
        }
    }
}
