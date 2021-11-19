package main.java.com.exceptions;

public class BookingFullException extends Exception{
    public BookingFullException() {
        super("Booking is full");
    }
}
