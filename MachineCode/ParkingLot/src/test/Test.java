package test;

import main.ParkingClient;
import main.models.ParkingLot;
import main.models.VehicleType;

public class Test {
    public static void main(String[] args) {
        ParkingClient parkingClient = new ParkingClient();
        ParkingLot parkingLot = parkingClient.createParkingLot(1234,2,6);

        displayFreeSpotsCount(parkingLot.getId(),parkingClient,VehicleType.CAR);
        displayFreeSpotsPerFloor(parkingLot.getId(),parkingClient,VehicleType.CAR);

        displayFreeSpotsCount(parkingLot.getId(),parkingClient,VehicleType.BIKE);
        displayFreeSpotsPerFloor(parkingLot.getId(),parkingClient,VehicleType.BIKE);

        displayFreeSpotsCount(parkingLot.getId(),parkingClient,VehicleType.TRUCK);
        displayFreeSpotsPerFloor(parkingLot.getId(),parkingClient,VehicleType.TRUCK);

        displayAllOccupiedSpots(parkingLot.getId(), parkingClient);

        Integer id1 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.CAR,"KA-01-DB-1234", "Black");
        Integer id2 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.CAR,"KA-02-CB-1334", "Red");
        Integer id3 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.CAR,"KA-01-DB-1133", "Black");
        Integer id4 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.CAR,"KA-05-HJ-8432", "White");
        Integer id5 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.CAR,"WB-45-HO-9032", "White");
        Integer id6 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.CAR,"KA-01-DF-8230", "Black");
        Integer id7 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.CAR,"KA-21-HS-2347", "Red");

        displayAllFreeSpotsCount(parkingLot.getId(),parkingClient);

        parkingClient.removeVehicle(id5);
        parkingClient.removeVehicle(id5);
        parkingClient.removeVehicle(id7);

        displayAllFreeSpotsCount(parkingLot.getId(),parkingClient);
        displayAllFreeSpotsPerFloor(parkingLot.getId(),parkingClient);
        displayAllOccupiedSpots(parkingLot.getId(), parkingClient);

        Integer id8 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.BIKE, "KA-01-DB-1541", "Black");
        Integer id9 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.TRUCK, "KA-32-SJ-5389", "Orange");
        Integer id10 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.TRUCK, "KL-54-DN-4582", "Green");
        Integer id11 = parkVehicle(parkingClient, parkingLot.getId(), VehicleType.TRUCK, "KL-12-HF-4542", "Green");

        displayAllFreeSpotsCount(parkingLot.getId(),parkingClient);
        displayAllFreeSpotsPerFloor(parkingLot.getId(),parkingClient);
        displayAllOccupiedSpots(parkingLot.getId(),parkingClient);
    }

    private static Integer parkVehicle(ParkingClient parkingClient, Integer parkingLotId, VehicleType vehicleType
            , String license, String color) {
        return parkingClient.parkVehicle(vehicleType, license, color, parkingLotId);
    }

    private static void displayFreeSpotsCount(Integer id, ParkingClient parkingClient, VehicleType vehicleType) {
        parkingClient.displayFreeSpotsCountForVehiclePerFloor(id, vehicleType);
    }

    private static void displayFreeSpotsPerFloor(Integer id, ParkingClient parkingClient, VehicleType vehicleType) {
        parkingClient.displayFreeSpotsForVehicle(id, vehicleType);
    }

    private static void displayOccupiedSpots(Integer id, ParkingClient parkingClient
            , VehicleType vehicleType) {
        parkingClient.displayOccupiedSpotsForVehicle(id, vehicleType);
    }

    private static void displayAllOccupiedSpots(Integer id, ParkingClient parkingClient) {
        displayOccupiedSpots(id, parkingClient, VehicleType.CAR);
        displayOccupiedSpots(id, parkingClient, VehicleType.BIKE);
        displayOccupiedSpots(id, parkingClient, VehicleType.TRUCK);
    }

    private static void displayAllFreeSpotsPerFloor(Integer id, ParkingClient parkingClient) {
        displayFreeSpotsPerFloor(id, parkingClient, VehicleType.CAR);
        displayFreeSpotsPerFloor(id, parkingClient, VehicleType.BIKE);
        displayFreeSpotsPerFloor(id, parkingClient, VehicleType.TRUCK);
    }

    private static void displayAllFreeSpotsCount(Integer id, ParkingClient parkingClient) {
        displayFreeSpotsCount(id, parkingClient, VehicleType.CAR);
        displayFreeSpotsCount(id, parkingClient, VehicleType.BIKE);
        displayFreeSpotsCount(id, parkingClient, VehicleType.TRUCK);
    }
}
