package test.java.com;
import main.java.com.exceptions.*;
import main.java.com.rideSharingService.*;

public class TestRide {
    public static void main(String[] args) throws UserAlreadyExistsException, VehicleAlreadyExistsException, DriverNotFoundException, RiderAlreadyExistsException, RideNotAvailableException, NoRidesAvailableException, RideAlreadyExistsForVehicleException, DriverAlreadyExistsException, VehicleNotFoundException {
        RideSharingService carPoolingService = new RideSharingService();
        // Add User
        carPoolingService.addUser("Rohan", 'M', 36);
        carPoolingService.addUser("Shashank", 'M', 29);
        carPoolingService.addUser("Nandini", 'F', 29);
        carPoolingService.addUser("Shipra", 'F', 27) ;
        carPoolingService.addUser("Gaurav", 'M', 29);
        carPoolingService.addUser("Rahul", 'M', 35);

        // Add Vehicle
        carPoolingService.addVehicle("Rahul", "XUV", "KA-05-1234");
        carPoolingService.addVehicle("Rohan", "Swift", "KA-01-12345");
        carPoolingService.addVehicle("Shashank", "Baleno", "TS-05-62395");
        carPoolingService.addVehicle("Shipra", "Polo", "KA-05-41491");
        carPoolingService.addVehicle("Shipra", "Activa", "KA-12-12332");

        // Offer ride
        carPoolingService.offerRide("Rohan", "Hyderabad", 1,
                "Swift", "KA-01-12345", "Bangalore");
        carPoolingService.offerRide("Shipra", "Bangalore", 1,
                "Activa", "KA-12-12332", "Mysore");
        carPoolingService.offerRide("Shipra", "Bangalore", 2,
                "Polo", "KA-05-41491", "Mysore");
        carPoolingService.offerRide("Shashank", "Hyderabad", 2,
                "Baleno","TS-05-62395", "Bangalore");
        carPoolingService.offerRide("Rahul", "Hyderabad", 5
                ,"XUV",  "KA-05-1234", "Bangalore");
        carPoolingService.offerRide("Rohan", "Bangalore", 1
                , "Swift", "KA-01-12345", "Pune");

        // Select ride
        carPoolingService.selectRide("Nandini", "Bangalore", "Mysore", 1);
        carPoolingService.selectRide("Gaurav", "Bangalore", "Mysore", 1
                ,"Activa");
        carPoolingService.selectRide("Shashank", "Mumbai", "Bangalore",1);
        carPoolingService.selectRide("Rohan", "Hyderabad", "Bangalore", 1
                ,"Baleno");
        carPoolingService.selectRide("Shashank", "Hyderabad", "Bangalore", 1
                ,"Polo");

        // End ride
        carPoolingService.endAllRides();
        carPoolingService.printStats();
    }
}
