package main;

import main.controllers.BookingController;
import main.controllers.ParkingLotController;
import main.factory.ParkingSpotFactory;
import main.factory.VehicleFactory;
import main.models.*;
import main.models.spots.Spot;
import main.persistence.*;
import main.services.BookingService;
import main.services.ParkingLotService;

public class ParkingClient {
    private FloorRepository floorRepository;
    private SpotRepository spotRepository;
    private BookingRepository bookingRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;

    private BookingController bookingController;
    private ParkingLotController parkingLotController;

    private BookingService bookingService;
    private ParkingLotService parkingLotService;

    public ParkingClient() {
        ParkingSpotFactory parkingSpotFactory = new ParkingSpotFactory();
        VehicleFactory vehicleFactory = new VehicleFactory();

        floorRepository = new FloorRepository();
        spotRepository = new SpotRepository(parkingSpotFactory);
        bookingRepository = new BookingRepository();
        parkingLotRepository = new ParkingLotRepository();
        vehicleRepository = new VehicleRepository(vehicleFactory);

        bookingService = new BookingService(vehicleRepository, spotRepository, bookingRepository, parkingLotController);
        parkingLotService = new ParkingLotService(parkingLotRepository, floorRepository, spotRepository);

        bookingController = new BookingController(bookingService);
        parkingLotController = new ParkingLotController(parkingLotService);

        bookingService.setParkingController(parkingLotController);

    }

    public ParkingLot createParkingLot(Integer parkingLotId, Integer totalFloors, Integer slotsPerFloor) {
        return parkingLotController.createParkingLot(parkingLotId, totalFloors, slotsPerFloor);
    }


    public void displayFreeSpotsCountForVehiclePerFloor(Integer parkingLotId, VehicleType vehicleType) {
        parkingLotController.displayFreeSpotsCountForVehiclePerFloor(parkingLotId, vehicleType);
    }

    public void displayFreeSpotsForVehicle(Integer parkingLotId, VehicleType vehicleType) {
        parkingLotController.displayFreeSpotsForVehicle(parkingLotId, vehicleType);
    }

    public void displayOccupiedSpotsForVehicle(Integer parkingLotId, VehicleType vehicleType) {
        parkingLotController.displayOccupiedSpotsForVehicle(parkingLotId, vehicleType);
    }

    public Integer parkVehicle(VehicleType vehicleType, String license, String color, Integer parkingLotId) {
        Booking booking = bookingController.parkVehicle(vehicleType, license, color, parkingLotId);
        if (booking != null) {
            System.out.println("Assigned Ticket ID " + booking.getId() + " against Vehicle Id " + booking.getVehicle().getLicense());
        }
        return booking == null ? -1 : booking.getId();
    }

    public void removeVehicle(Integer ticketId) {
        bookingController.removeVehicle(ticketId);
    }
}
