package main.java.com.rideSharingService;
import main.java.com.controllers.*;
import main.java.com.database.*;
import main.java.com.exceptions.*;

public class RideSharingService {
    private UsersManager usersManager;
    private RidersManager ridersManager;
    private RidesManager ridesManager;
    private VehicleManager vehiclesManager;
    private DriversManager driversManager;

    private UserController userController;
    private RidesController ridesController;
    private VehiclesController vehiclesController;

    public RideSharingService() {
        usersManager = new UsersManager();
        ridersManager = new RidersManager();
        ridesManager = new RidesManager();
        vehiclesManager = new VehicleManager();
        driversManager = new DriversManager();

        userController = new UserController(usersManager);
        ridesController = new RidesController(usersManager, ridersManager, ridesManager, vehiclesManager, driversManager);
        vehiclesController = new VehiclesController(vehiclesManager, usersManager);
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

    public void endRide(Integer rideId) throws RideNotFoundException, NoRidersFound {
        ridesController.endRide(rideId);
    }

    public void endAllRides() {
        ridesController.endAllRides();
    }

    public void printStats() {
        userController.printStats();
    }
}
