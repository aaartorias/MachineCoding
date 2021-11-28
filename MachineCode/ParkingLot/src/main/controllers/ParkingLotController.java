package main.controllers;

import main.models.ParkingLot;
import main.models.VehicleType;
import main.models.spots.Spot;
import main.services.ParkingLotService;

import java.util.ArrayList;

public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public ParkingLot createParkingLot(Integer parkingLotId, Integer totalFloors, Integer slotsPerFloor) {
        return parkingLotService.createParkingLot(parkingLotId, totalFloors, slotsPerFloor);
    }

    public Spot getFirstFreeSpot(Integer parkingLotId, VehicleType vehicleType) {
        return parkingLotService.getFirstFreeSpot(parkingLotId, vehicleType);
    }

    // display parking lot status  <display_type> <vehicle_type>
    public void displayFreeSpotsCountForVehiclePerFloor(Integer parkingLotId, VehicleType vehicleType) {
        parkingLotService.displayFreeSpotsCountForVehiclePerFloor(parkingLotId, vehicleType);
    }

    public void displayFreeSpotsForVehicle(Integer parkingLotId, VehicleType vehicleType) {
        parkingLotService.displayFreeSpotsForVehicle(parkingLotId, vehicleType);
    }

    public void displayOccupiedSpotsForVehicle(Integer parkingLotId, VehicleType vehicleType) {
        parkingLotService.displayOccupiedSpotsForVehicle(parkingLotId, vehicleType);
    }

//    display free_count <vehicle_type>
//    No. of free slots for <vehicle_type> on Floor <floor_no>: <no_of_free_slots>
//    The above will be printed for each floor.


//    display free_slots <vehicle_type>
//    Free slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
//    The above will be printed for each floor.


//    display occupied_slots <vehicle_type>
//    Occupied slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
//    The above will be printed for each floor.
}
