package main.java.com.interfaces;

import main.java.com.models.BookingStatus;

public interface IBooking {
    Integer getId();
    Integer getRideId();
    Integer getPassengerId();
    Integer getDriverId();
    BookingStatus getStatus();
    void cancelBooking();
    void endBooking();
//    void acceptBooking();
}
