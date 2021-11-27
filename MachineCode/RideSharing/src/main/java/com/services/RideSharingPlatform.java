package main.java.com.services;
import main.java.com.controllers.*;
import main.java.com.databases.*;
import main.java.com.exceptions.*;

public class RideSharingPlatform {
    private UsersManager usersManager;
    private PassengersManager passengersManager;
    private RidesManager ridesManager;
    private VehicleManager vehiclesManager;
    private DriversManager driversManager;

    private UserController userController;
    private RidesController ridesController;
    private VehiclesController vehiclesController;
    private RideService rideService;
    private UserService userService;
    private VehicleService vehicleService;

    public RideSharingPlatform() {
        usersManager = new UsersManager();
        passengersManager = new PassengersManager();
        ridesManager = new RidesManager();
        vehiclesManager = new VehicleManager();
        driversManager = new DriversManager();
        rideService = new RideService(usersManager, passengersManager, ridesManager, vehiclesManager, driversManager);
        userService = new UserService(usersManager);
        vehicleService = new VehicleService(vehiclesManager, usersManager);
        userController = new UserController(userService);
        ridesController = new RidesController(rideService);
        vehiclesController = new VehiclesController(vehicleService);

    }

    public void  addUser(String name, char gender, int age) throws UserAlreadyExistsException {
        userController.addUser(name, gender, age);
    }

    public void addVehicle(String owner, String model, String license)
            throws VehicleAlreadyExistsException, DriverNotFoundException {
        vehiclesController.registerVehicle(owner, model, license);
    }

    public void offerRide(String name, String origin, int availableSeats, String vehicleName
            ,String vehicleLicense,String destination)
            throws DriverNotFoundException, VehicleNotFoundException, RideAlreadyExistsForVehicleException,
            RiderAlreadyExistsException, DriverAlreadyExistsException {
        try {
            ridesController.createRide(name,origin, availableSeats, vehicleName, vehicleLicense, destination);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selectRide(String name, String origin
            ,String destination, int seatsRequested, String preferredVehicle)
            throws RiderAlreadyExistsException, DriverNotFoundException,
            RideNotAvailableException, NoRidesAvailableException {
        try {
            ridesController.matchRide(name, origin, destination, seatsRequested, preferredVehicle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selectRide(String name, String origin
            ,String destination, int seatsRequested)
            throws DriverNotFoundException, RiderAlreadyExistsException,
            NoRidesAvailableException, RideNotAvailableException {
        try {
            ridesController.matchRide(name, origin, destination, seatsRequested);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void endRide(Integer rideId) throws Exception {
        ridesController.endRide(rideId);
    }

    public void endAllRides() {
        ridesController.endAllRides();
    }

    public void printStats() {
        userController.printStats();
    }

    public void startRide(Integer rideId) throws RideNotFoundException {
        ridesController.startRide(rideId);
    }
}
