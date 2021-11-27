package main.java.com.services;

import main.java.com.persistence.*;
import main.java.com.exceptions.*;
import main.java.com.models.Ride;
import main.java.com.models.User;
import main.java.com.models.Vehicle;

import java.util.ArrayList;

public class RideService {

    private UsersRepository usersRepository;
    private ActivePassengersRepository activePassengersRepository;
    private RidesRepository ridesRepository;
    private VehiclesRepository vehiclesManager;
    private DriversRepository driversRepository;

    public RideService(UsersRepository usersRepository, ActivePassengersRepository activePassengersRepository, RidesRepository ridesRepository
            , VehiclesRepository vehiclesManager, DriversRepository driversRepository) {
        this.usersRepository = usersRepository;
        this.activePassengersRepository = activePassengersRepository;
        this.ridesRepository = ridesRepository;
        this.vehiclesManager = vehiclesManager;
        this.driversRepository = driversRepository;
    }

    public void createRide(String name, String origin, String destination, String vehicleLicense, int availableSeats)
            throws DriverNotFoundException, RideAlreadyExistsForVehicleException, VehicleNotFoundException
            , RiderAlreadyExistsException {
        User driver =  usersRepository.getUser(name);
        if (ridesRepository.hasRideForVehicle(vehicleLicense)) {
            throw new RideAlreadyExistsForVehicleException();
        }
        Vehicle vehicle = vehiclesManager.getVehicle(vehicleLicense);
        Ride ride = new Ride(origin, destination, driver,vehicle, availableSeats);
        ridesRepository.addRide(ride);
        try {
            driversRepository.addDriver(driver);
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.addRidesOffered();
    }

    public void matchRide(String name, String origin
            ,String destination, int seatsRequested, String preferredVehicle)
            throws RiderAlreadyExistsException, RideNotAvailableException,
            NoRidesAvailableException, DriverNotFoundException {

        if (activePassengersRepository.riderExists(name)) {
            throw new RiderAlreadyExistsException();
        }
        Ride match = null;
        for(Ride ride : ridesRepository.getAvailableRides()) {
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
        User rider = usersRepository.getUser(name); // handle exception
        match.reserveSeats(seatsRequested);
        rider.addRidesTaken();
        activePassengersRepository.addRider(rider);
    }

    public void matchRide(String name, String origin
            ,String destination, int seatsRequested)
            throws NoRidesAvailableException, DriverNotFoundException, RiderAlreadyExistsException
            , RideNotAvailableException, RideNotFoundException {

        if (activePassengersRepository.riderExists(name)) {
            throw new RiderAlreadyExistsException();
        }
        Ride match = null;
        for(Ride ride : ridesRepository.getAvailableRides()) {
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
        User rider = usersRepository.getUser(name); // handle exception
        match.reserveSeats(seatsRequested);
        rider.addRidesTaken();
        activePassengersRepository.addRider(rider);

        if (match.getAvailableSeats() == 0) startRide(match.getId());
    }

    public void startRide(Integer ride) throws RideNotFoundException {
        ridesRepository.getRide(ride).startTrip();
    }

    public void endRide(Integer rideId) throws NoRidersFound, RideNotFoundException {
        Ride ride = ridesRepository.getRide(rideId);
        ride.endTrip();
        ArrayList<User> riders = ride.getRiders();
        if (riders == null) {
            throw new NoRidersFound();
        }
        activePassengersRepository.removeRiders(riders);
    }

    public void endAllRides() {
        try {
            for (Integer ride : ridesRepository.getRides()) {
                endRide(ride);
            }
        } catch (RideNotFoundException | NoRidersFound e) {
            System.out.println(e);
            //.printStackTrace()
        }
    }
}
