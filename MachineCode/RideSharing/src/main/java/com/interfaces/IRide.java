package main.java.com.interfaces;

import main.java.com.models.RideStatus;
import main.java.com.models.User;
import main.java.com.models.Vehicle;

import java.util.ArrayList;

public interface IRide {
    public String getSource();
    public String getDestination();
    public User getDriver();
    public Vehicle getVehicle();
    public RideStatus getStatus();
    public void startRide();
    public void endRide();
    public Integer getId();
    public Integer getAvailableSeats();
    public boolean isAvailable();
    public void reserveSeats(Integer seatsRequested);
    public ArrayList<User> getRiders();
}
