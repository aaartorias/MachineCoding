package main.services;

import main.controllers.ParkingLotController;
import main.models.Booking;
import main.models.VehicleType;
import main.models.spots.Spot;
import main.models.vehicles.Vehicle;
import main.persistence.BookingRepository;
import main.persistence.SpotRepository;
import main.persistence.VehicleRepository;

public class BookingService {

    VehicleRepository vehicleRepository;
    SpotRepository spotRepository;
    BookingRepository bookingRepository;
    ParkingLotController parkingLotController;

    public BookingService(VehicleRepository vehicleRepository, SpotRepository spotRepository
            , BookingRepository bookingRepository, ParkingLotController parkingLotController) {
        this.vehicleRepository = vehicleRepository;
        this.spotRepository = spotRepository;
        this.bookingRepository = bookingRepository;
        this.parkingLotController = parkingLotController;
    }

    // create booking
    public Booking createBooking(VehicleType vehicleType, String license, String color, Integer parkingLotId) {
        Vehicle vehicle = vehicleRepository.addVehicle(vehicleType, license, color);
        Spot spot = parkingLotController.getFirstFreeSpot(parkingLotId, vehicleType);
        Booking booking = null;
        if (spot == null) {
            System.out.println("No spots available");
        } else {
            booking = bookingRepository.createBooking(vehicle, spot);
            booking.setVehicle(vehicle);
            spot.vehicleAssigned();
            booking.setSpot(spot);
        }
        return booking;
    }


    // collect booking
}
