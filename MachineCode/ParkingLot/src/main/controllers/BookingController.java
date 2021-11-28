package main.controllers;

import main.models.Booking;
import main.models.VehicleType;
import main.models.spots.Spot;
import main.models.vehicles.Vehicle;
import main.services.BookingService;

public class BookingController {
    BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Booking parkVehicle(VehicleType vehicleType, String license, String color, Integer parkingLotId) {
        return bookingService.createBooking(vehicleType, license, color, parkingLotId);
    }
}
