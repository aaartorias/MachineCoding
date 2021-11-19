package main.java.com.exceptions;

public class RequestedSeatsNotAvailableException extends Exception{
    public RequestedSeatsNotAvailableException() {
        super("Requested seats are not available");
    }
}
