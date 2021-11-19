package main.java.com.interfaces;

import main.java.com.exceptions.BookingFullException;
import main.java.com.exceptions.RequestedSeatsNotAvailableException;
import main.java.com.models.Booking;

import java.util.ArrayList;

public interface IBookingStore {
    Booking addBooking(User creator, Game game, Integer seatsRequested) throws BookingFullException, RequestedSeatsNotAvailableException;
    Booking getBooking(Integer id);
    ArrayList<Booking> getAllBookings();
}
