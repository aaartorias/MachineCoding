package main.java.com.controllers;

import main.java.com.exceptions.BookingFullException;
import main.java.com.exceptions.RequestedSeatsNotAvailableException;
import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;
import main.java.com.models.Booking;
import main.java.com.persistence.BookingStore;

public class BookingController {
    private BookingStore bookingStore;
    private ObservableController observableController;

    public BookingController(BookingStore bookingStore, ObservableController observableController) {
        this.bookingStore = bookingStore;
        this.observableController = observableController;
    }

    public Booking createBooking(User creator, Game game, Integer seatsRequested)
            throws BookingFullException, RequestedSeatsNotAvailableException {

        Booking booking= bookingStore.addBooking(creator, game, seatsRequested);
        if (booking.getGame().getSeatsAvailable() == booking.getGame().getOfferedSeats()) {
            booking.getGame().startBooking();
        }
        booking.getGame().bookSeats(seatsRequested);
        if (booking.getGame().getSeatsAvailable() == 0) {
            booking.getGame().startGame();
        }
        //observableController
        return booking;
    }

    //public Booking book(User requester, )
    // book tickets
}
