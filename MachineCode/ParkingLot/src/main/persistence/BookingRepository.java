package main.persistence;

import main.models.Booking;
import main.interfaces.repository.IBookingRepository;
import main.interfaces.repository.Store;
import main.models.spots.Spot;
import main.models.vehicles.Vehicle;

public class BookingRepository extends Store<Integer, Booking> implements IBookingRepository {
    @Override
    public Booking getTicket(Integer id) {
        return get(id);
    }

    @Override
    public Booking createBooking(Vehicle vehicle, Spot spot) {
        Booking booking = new Booking(vehicle, spot);
        add(booking.getId(), booking);
        return booking;
    }

    @Override
    public void collectTicket(Integer id) {
        Booking booking = get(id);
        booking.collect();
    }

}
