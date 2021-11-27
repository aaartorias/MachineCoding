package main.java.com.services;

import main.java.com.databases.*;
import main.java.com.exceptions.*;
import main.java.com.models.Ride;
import main.java.com.models.User;
import main.java.com.models.Vehicle;

import java.util.ArrayList;

public class RideService {

    private UsersManager usersManager;
    private PassengersManager passengersManager;
    private RidesManager ridesManager;
    private VehicleManager vehiclesManager;
    private DriversManager driversManager;

    public RideService(UsersManager usersManager, PassengersManager passengersManager, RidesManager ridesManager
            , VehicleManager vehiclesManager, DriversManager driversManager) {
        this.usersManager = usersManager;
        this.passengersManager = passengersManager;
        this.ridesManager = ridesManager;
        this.vehiclesManager = vehiclesManager;
        this.driversManager = driversManager;
    }

    public void createRide(String name, String origin, String destination, String vehicleLicense, int availableSeats)
            throws DriverNotFoundException, RideAlreadyExistsForVehicleException, VehicleNotFoundException
            , RiderAlreadyExistsException {
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

        if (passengersManager.riderExists(name)) {
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
        passengersManager.addRider(rider);
    }

    public void matchRide(String name, String origin
            ,String destination, int seatsRequested)
            throws NoRidesAvailableException, DriverNotFoundException, RiderAlreadyExistsException
            , RideNotAvailableException, RideNotFoundException {

        if (passengersManager.riderExists(name)) {
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
        passengersManager.addRider(rider);

        if (match.getAvailableSeats() == 0) startRide(match.getId());
    }

    public void startRide(Integer ride) throws RideNotFoundException {
        ridesManager.getRide(ride).startTrip();
    }

    public void endRide(Integer rideId) throws NoRidersFound, RideNotFoundException {
        Ride ride = ridesManager.getRide(rideId);
        ride.endTrip();
        ArrayList<User> riders = ride.getRiders();
        if (riders == null) {
            throw new NoRidersFound();
        }
        passengersManager.removeRiders(riders);
    }

    public void endAllRides() {
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
