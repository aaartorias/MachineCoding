package main.java.com.persistence;

import main.java.com.exceptions.BookingFullException;
import main.java.com.exceptions.RequestedSeatsNotAvailableException;
import main.java.com.interfaces.IBookingStore;
import main.java.com.interfaces.Game;
import main.java.com.interfaces.Store;
import main.java.com.interfaces.User;
import main.java.com.models.Booking;

import java.util.ArrayList;

public class BookingStore extends Store<Integer, Booking> implements IBookingStore {
    @Override
    public Booking addBooking(User creator, Game game, Integer seatsRequested)
            throws BookingFullException, RequestedSeatsNotAvailableException {
        if (game.getSeatsAvailable() == 0) {
            throw new BookingFullException();
        } else if (game.getSeatsAvailable() < seatsRequested) {
            throw new RequestedSeatsNotAvailableException();
        }
        Booking booking = new Booking(creator, game, seatsRequested);
        add(booking.getBookingId(),booking);
        return booking;
    }

    @Override
    public Booking getBooking(Integer id) {
        return get(id);
    }

    @Override
    public ArrayList<Booking> getAllBookings() {
        return getAllBookings();
    }
}
