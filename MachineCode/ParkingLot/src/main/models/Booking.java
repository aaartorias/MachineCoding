package main.models;

import main.models.spots.Spot;
import main.models.vehicles.Vehicle;

public class Booking {
    private Integer id;
    private BookingStatus bookingStatus;
    private static Integer counter = 0;
    private Spot spot;
    private Vehicle vehicle;

    public Booking(Vehicle vehicle, Spot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.bookingStatus = BookingStatus.CREATED;
        this.id = ++counter;
    }

    public Integer getId() {
        return id;
    }

    public BookingStatus getStatus() {
        return bookingStatus;
    }

    public void collect() {
        bookingStatus = BookingStatus.COLLECTED;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
