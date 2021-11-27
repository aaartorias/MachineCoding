package test.java.com;
import main.java.com.exceptions.*;
import main.java.com.services.*;

public class TestRide {
    public static void main(String[] args) throws Exception {
        RideSharingPlatform rideSharingPlatform = new RideSharingPlatform();
        addUsers(rideSharingPlatform); // Add User
        addVehicle(rideSharingPlatform); // Add Vehicle

        offerRides(rideSharingPlatform); // Offer ride
        selectRides(rideSharingPlatform); // Select ride

        rideSharingPlatform.endAllRides(); // End ride
        rideSharingPlatform.printStats(); // print stats

        rideSharingPlatform.startRide(1);
    }

    private static void selectRides(RideSharingPlatform rideSharingPlatform)
            throws DriverNotFoundException, RideNotAvailableException
            , NoRidesAvailableException, RiderAlreadyExistsException {
        rideSharingPlatform.selectRide("Nandini", "Bangalore", "Mysore", 1);
        rideSharingPlatform.selectRide("Gaurav", "Bangalore", "Mysore", 1
                ,"Activa");
        rideSharingPlatform.selectRide("Shashank", "Mumbai", "Bangalore",1);
        rideSharingPlatform.selectRide("Rohan", "Hyderabad", "Bangalore", 1
                ,"Baleno");
        rideSharingPlatform.selectRide("Shashank", "Hyderabad", "Bangalore", 1
                ,"Polo");
    }

    private static void offerRides(RideSharingPlatform rideSharingPlatform)
            throws DriverNotFoundException, VehicleNotFoundException, DriverAlreadyExistsException
            , RideAlreadyExistsForVehicleException, RiderAlreadyExistsException {
        rideSharingPlatform.offerRide("Rohan", "Hyderabad", 1,
                "Swift", "KA-01-12345", "Bangalore");
        rideSharingPlatform.offerRide("Shipra", "Bangalore", 1,
                "Activa", "KA-12-12332", "Mysore");
        rideSharingPlatform.offerRide("Shipra", "Bangalore", 2,
                "Polo", "KA-05-41491", "Mysore");
        rideSharingPlatform.offerRide("Shashank", "Hyderabad", 2,
                "Baleno","TS-05-62395", "Bangalore");
        rideSharingPlatform.offerRide("Rahul", "Hyderabad", 5
                ,"XUV",  "KA-05-1234", "Bangalore");
        rideSharingPlatform.offerRide("Rohan", "Bangalore", 1
                , "Swift", "KA-01-12345", "Pune");
    }

    private static void addVehicle(RideSharingPlatform rideSharingPlatform)
            throws VehicleAlreadyExistsException, DriverNotFoundException {
        rideSharingPlatform.addVehicle("Rahul", "XUV", "KA-05-1234");
        rideSharingPlatform.addVehicle("Rohan", "Swift", "KA-01-12345");
        rideSharingPlatform.addVehicle("Shashank", "Baleno", "TS-05-62395");
        rideSharingPlatform.addVehicle("Shipra", "Polo", "KA-05-41491");
        rideSharingPlatform.addVehicle("Shipra", "Activa", "KA-12-12332");
    }

    private static void addUsers(RideSharingPlatform rideSharingPlatform) throws UserAlreadyExistsException {
        // Add User
        rideSharingPlatform.addUser("Rohan", 'M', 36);
        rideSharingPlatform.addUser("Shashank", 'M', 29);
        rideSharingPlatform.addUser("Nandini", 'F', 29);
        rideSharingPlatform.addUser("Shipra", 'F', 27) ;
        rideSharingPlatform.addUser("Gaurav", 'M', 29);
        rideSharingPlatform.addUser("Rahul", 'M', 35);
    }

}
