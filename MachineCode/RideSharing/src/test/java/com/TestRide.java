package test.java.com;
import main.java.com.RideSharingClient;
import main.java.com.exceptions.*;

public class TestRide {
    public static void main(String[] args) throws Exception {
        RideSharingClient rideSharingClient = new RideSharingClient();
        addUsers(rideSharingClient); // Add User
        addVehicle(rideSharingClient); // Add Vehicle

        offerRides(rideSharingClient); // Offer ride
        selectRides(rideSharingClient); // Select ride

        rideSharingClient.endAllRides(); // End ride
        rideSharingClient.printStats(); // print stats

        rideSharingClient.startRide(1);
    }

    private static void selectRides(RideSharingClient rideSharingClient)
            throws DriverNotFoundException, RideNotAvailableException
            , NoRidesAvailableException, RiderAlreadyExistsException {
        rideSharingClient.selectRide("Nandini", "Bangalore", "Mysore", 1);
        rideSharingClient.selectRide("Gaurav", "Bangalore", "Mysore", 1
                ,"Activa");
        rideSharingClient.selectRide("Shashank", "Mumbai", "Bangalore",1);
        rideSharingClient.selectRide("Rohan", "Hyderabad", "Bangalore", 1
                ,"Baleno");
        rideSharingClient.selectRide("Shashank", "Hyderabad", "Bangalore", 1
                ,"Polo");
    }

    private static void offerRides(RideSharingClient rideSharingClient)
            throws DriverNotFoundException, VehicleNotFoundException, DriverAlreadyExistsException
            , RideAlreadyExistsForVehicleException, RiderAlreadyExistsException {
        rideSharingClient.offerRide("Rohan", "Hyderabad", 1,
                "Swift", "KA-01-12345", "Bangalore");
        rideSharingClient.offerRide("Shipra", "Bangalore", 1,
                "Activa", "KA-12-12332", "Mysore");
        rideSharingClient.offerRide("Shipra", "Bangalore", 2,
                "Polo", "KA-05-41491", "Mysore");
        rideSharingClient.offerRide("Shashank", "Hyderabad", 2,
                "Baleno","TS-05-62395", "Bangalore");
        rideSharingClient.offerRide("Rahul", "Hyderabad", 5
                ,"XUV",  "KA-05-1234", "Bangalore");
        rideSharingClient.offerRide("Rohan", "Bangalore", 1
                , "Swift", "KA-01-12345", "Pune");
    }

    private static void addVehicle(RideSharingClient rideSharingClient)
            throws VehicleAlreadyExistsException, DriverNotFoundException {
        rideSharingClient.addVehicle("Rahul", "XUV", "KA-05-1234");
        rideSharingClient.addVehicle("Rohan", "Swift", "KA-01-12345");
        rideSharingClient.addVehicle("Shashank", "Baleno", "TS-05-62395");
        rideSharingClient.addVehicle("Shipra", "Polo", "KA-05-41491");
        rideSharingClient.addVehicle("Shipra", "Activa", "KA-12-12332");
    }

    private static void addUsers(RideSharingClient rideSharingClient) throws UserAlreadyExistsException {
        // Add User
        rideSharingClient.addUser("Rohan", 'M', 36);
        rideSharingClient.addUser("Shashank", 'M', 29);
        rideSharingClient.addUser("Nandini", 'F', 29);
        rideSharingClient.addUser("Shipra", 'F', 27) ;
        rideSharingClient.addUser("Gaurav", 'M', 29);
        rideSharingClient.addUser("Rahul", 'M', 35);
    }

}
