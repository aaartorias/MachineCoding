package main.services;

import main.factory.ParkingSpotFactory;
import main.interfaces.repository.IFloorRepository;
import main.interfaces.repository.IParkingLotRepository;
import main.interfaces.repository.ISpotRepository;
import main.models.Floor;
import main.models.ParkingLot;
import main.models.SpotType;
import main.models.VehicleType;
import main.models.spots.Spot;

import java.util.ArrayList;

public class ParkingLotService {
    private IParkingLotRepository parkingLotRepository;
    private IFloorRepository floorRepository;
    private ISpotRepository spotRepository;
    private ParkingSpotFactory parkingSpotFactory;

    public ParkingLotService(IParkingLotRepository parkingLotRepository
            , IFloorRepository floorRepository, ISpotRepository spotRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.floorRepository = floorRepository;
        this.spotRepository = spotRepository;
    }

    // create parking lot
    public ParkingLot createParkingLot(Integer parkingLotId, Integer totalFloors, Integer slotsPerFloor) {
        ParkingLot parkingLot = parkingLotRepository.createParking(parkingLotId);//new ParkingLot(parkingLotId);
        addFloors(parkingLot,totalFloors);
        addSpots(parkingLot, slotsPerFloor);
        return parkingLot;
    }

    private void addFloors(ParkingLot parkingLot, Integer totalFloors) {
        for ( int localId = 1; localId <= totalFloors; localId++) {
            Floor floor = floorRepository.addFloor(localId);
            parkingLot.addFloor(floor);
        }
    }

    private void addSpots(ParkingLot parkingLot, Integer slotsPerFloor) {
        for (Floor floor : parkingLot.getFloors()) {
            for (int localId = 1; localId <= slotsPerFloor; localId++) {
                Spot spot = spotRepository.addSpot(localId);
                floor.addSpot(spot);
            }
        }
    }

    public Spot getFirstFreeSpot(Integer parkingLotId, VehicleType vehicleType) {
        Spot availableSpot = null;
        SpotType spotType = getSpotTypeFromVehicleType(vehicleType);
        if (spotType == null) {
            // throw error stating no spot available for hte vehicle type
            System.out.println("No spot available for the vehicle type : " + vehicleType);
        }
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(parkingLotId);
        for (Floor floor: parkingLot.getFloors()) {
            ArrayList<Spot> freeSpots = floor.getAllFreeSpots(spotType);
            if (!freeSpots.isEmpty()) {
                availableSpot = freeSpots.get(0);
                break;
            }
        }
        return availableSpot;
    }

    public void displayFreeSpotsCountForVehiclePerFloor(Integer parkingLotId, VehicleType vehicleType) {
        String vehicleTypeStr = convertVehicleTypeToString(vehicleType);
        SpotType spotType = getSpotTypeFromVehicleType(vehicleType);
        if (spotType == null) {
            // throw error stating no spot available for hte vehicle type
            System.out.println("No spot available for the vehicle type : " + vehicleType);
        }
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(parkingLotId);
        for (Floor floor: parkingLot.getFloors()) {
            int totalFreeSpots = 0;
            ArrayList<Spot> freeSpots = floor.getAllFreeSpots(spotType);
            //if (!freeSpots.isEmpty()) {
                totalFreeSpots = freeSpots.size();
                System.out.println("No. of free slots for " + vehicleTypeStr + " on Floor "
                        + floor.getLocalId() + " : " + totalFreeSpots);
            //}
        }
    }

    public void displayFreeSpotsForVehicle(Integer parkingLotId, VehicleType vehicleType) {
        String vehicleTypeStr = convertVehicleTypeToString(vehicleType);
        SpotType spotType = getSpotTypeFromVehicleType(vehicleType);
        if (spotType == null) {
            // throw error stating no spot available for hte vehicle type
            System.out.println("No spot available for the vehicle type : " + vehicleType);
        }

        ParkingLot parkingLot = parkingLotRepository.getParkingLot(parkingLotId);
        for (Floor floor: parkingLot.getFloors()) {
            ArrayList<Spot> freeSpots = floor.getAllFreeSpots(spotType);
            String freeSpotIds = getSpotIds(freeSpots);
//            if (!freeSpots.isEmpty()) {
//                System.out.println("Free slots for " + vehicleTypeStr + " on Floor "
//                        + floor.getLocalId() + " : " + getSpotIds(freeSpots));
//            }
            System.out.println("Free slots for " + vehicleTypeStr + " on Floor "
                    + floor.getLocalId() + " : " + freeSpotIds);

        }
    }

    public void displayOccupiedSpotsForVehicle(Integer parkingLotId, VehicleType vehicleType) {
        String vehicleTypeStr = convertVehicleTypeToString(vehicleType);
        SpotType spotType = getSpotTypeFromVehicleType(vehicleType);
        if (spotType == null) {
            // throw error stating no spot available for hte vehicle type
            System.out.println("No spot available for the vehicle type : " + vehicleType);
        }

        ParkingLot parkingLot = parkingLotRepository.getParkingLot(parkingLotId);
        for (Floor floor: parkingLot.getFloors()) {
            ArrayList<Spot> freeSpots = floor.getAllOccupiedSpots(spotType);
            String allOccupiedSpotIds = "";
            if (!freeSpots.isEmpty()) {
                allOccupiedSpotIds = getSpotIds(freeSpots);
            }
            System.out.println("Occupied slots for " + vehicleTypeStr + " on Floor "
                    + floor.getLocalId() + " : " + allOccupiedSpotIds);
        }
    }

    private String getSpotIds(ArrayList<Spot> freeSpots) {
        String freeSpotsToStr = " ";
        for (Spot spot: freeSpots) {
            freeSpotsToStr += spot.getLocalId().toString() + " ";
        }
        return freeSpotsToStr;
    }


    private SpotType getSpotTypeFromVehicleType(VehicleType vehicleType) {
        SpotType spotType = null;
        if (vehicleType == VehicleType.BIKE) {
            spotType = SpotType.BIKE;
        } else if (vehicleType == VehicleType.CAR) {
            spotType = SpotType.CAR;
        } else if (vehicleType == VehicleType.TRUCK) {
            spotType = SpotType.TRUCK;
        }
        return spotType;
    }

    private String convertVehicleTypeToString(VehicleType vehicleType) {
        return vehicleType.toString();
    }

//        String vehicleTypeStr = "";
//        if (vehicleType == VehicleType.BIKE) {
//            vehicleTypeStr = "BIKE";
//        } else if (vehicleType == VehicleType.CAR) {
//            vehicleTypeStr = "CAR";
//        } else if (vehicleType == VehicleType.TRUCK) {
//            vehicleTypeStr = "TRUCK";
//        }
//        return vehicleTypeStr;
//    }
}
