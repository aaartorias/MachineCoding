package test;

import main.ParkingClient;
import main.models.ParkingLot;
import main.models.VehicleType;

public class Test {
    public static void main(String[] args) {
        ParkingClient parkingClient = new ParkingClient();
        ParkingLot parkingLot = parkingClient.createParkingLot(1234,2,6);

        parkingClient.displayFreeSpotsCountForVehiclePerFloor(parkingLot.getId(), VehicleType.CAR);
        parkingClient.displayFreeSpotsForVehicle(parkingLot.getId(),VehicleType.CAR);

        parkingClient.displayFreeSpotsCountForVehiclePerFloor(parkingLot.getId(), VehicleType.BIKE);
        parkingClient.displayFreeSpotsForVehicle(parkingLot.getId(),VehicleType.BIKE);

        parkingClient.displayFreeSpotsCountForVehiclePerFloor(parkingLot.getId(), VehicleType.TRUCK);
        parkingClient.displayFreeSpotsForVehicle(parkingLot.getId(),VehicleType.TRUCK);

    }
}
