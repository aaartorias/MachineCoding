package main.java.com.models;

import main.java.com.interfaces.IBooking;

public class Booking implements IBooking {
    private Integer id;
    private Integer rideId;
    private Integer passengerId;
    private Integer driverId;
    private BookingStatus status;
    private static Integer counter = 0;

    public Booking(Integer rideId, Integer passengerId, Integer driverId) {
        this.rideId = rideId;
        this.passengerId = passengerId;
        this.driverId = driverId;
        this.id = counter++;
        status = BookingStatus.ACCEPTED;
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getRideId() {
        return null;
    }

    @Override
    public Integer getPassengerId() {
        return passengerId;
    }

    @Override
    public Integer getDriverId() {
        return driverId;
    }

    @Override
    public BookingStatus getStatus() {
        return status;
    }

    @Override
    public void cancelBooking() {
        status = BookingStatus.CANCELLED;
    }

    @Override
    public void endBooking() {
        status = BookingStatus.TAKEN;
    }

    //    @Override
//    public void acceptBooking() {
//        status = BookingStatus.ACCEPTED;
//    }

}
