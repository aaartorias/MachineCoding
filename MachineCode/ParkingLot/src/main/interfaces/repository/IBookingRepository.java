package main.interfaces.repository;

import main.models.Booking;
import main.models.spots.Spot;
import main.models.vehicles.Vehicle;

public interface IBookingRepository {
    Booking getTicket(Integer id);
    Booking createBooking(Vehicle vehicle, Spot spot);
    void collectTicket(Integer id);
}
