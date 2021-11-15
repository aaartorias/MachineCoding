package test;

import main.Model.Size;
import main.ParkingService;

public class Test {
    public static void main(String[] args) {
        ParkingService parkingService = new ParkingService();
        parkingService.createParkingLot(1,3,5);
        Integer ticketId =  parkingService.parkVehicle(Size.CAR , "1", "blue");
        parkingService.unparkVehicle(ticketId);
        parkingService.display();
    }
}
