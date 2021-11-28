package main.java.com;
import main.java.com.controllers.*;
import main.java.com.persistence.*;
import main.java.com.exceptions.*;
import main.java.com.services.RideService;
import main.java.com.services.UserService;
import main.java.com.services.VehicleService;

public class RideSharingClient {
    private UsersRepository usersRepository;
    private ActivePassengersRepository activePassengersRepository;
    private RidesRepository ridesRepository;
    private VehiclesRepository vehiclesRepository;
    private DriversRepository driversRepository;

    private UserController userController;
    private RidesController ridesController;
    private VehiclesController vehiclesController;

    private RideService rideService;
    private UserService userService;
    private VehicleService vehicleService;

    public RideSharingClient() {
        usersRepository = new UsersRepository();
        activePassengersRepository = new ActivePassengersRepository();
        ridesRepository = new RidesRepository();
        vehiclesRepository = new VehiclesRepository();
        driversRepository = new DriversRepository();

        rideService = new RideService(usersRepository, activePassengersRepository, ridesRepository, vehiclesRepository, driversRepository);
        userService = new UserService(usersRepository);
        vehicleService = new VehicleService(vehiclesRepository, usersRepository);

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
