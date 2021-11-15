package main.java.com.database;

import main.java.com.exceptions.RideNotAvailableException;
import main.java.com.exceptions.RideNotFoundException;
import main.java.com.exceptions.RiderAlreadyExistsException;
import main.java.com.model.Ride;

import java.util.Collection;
import java.util.HashMap;

public class RidesManager {
    private HashMap<Integer, Ride> rides;

    public RidesManager() {
        rides = new HashMap<>();
    }

    public void addRide(Ride ride) throws RiderAlreadyExistsException {
        if (rides.containsKey(ride.getId())) {
            throw new RiderAlreadyExistsException();
        }
        rides.put(ride.getId(),ride);
    }

    public Ride getRide(Integer id) throws RideNotFoundException {
        if (!rides.containsKey(id)) {
            throw new RideNotFoundException();
        }
        return rides.get(id);
    }

    public Collection<Ride> getAvailableRides() throws RideNotAvailableException {
        if (isEmpty()) {
            throw new RideNotAvailableException();
        }
        Collection<Ride> availableRides = null;
        for (Ride ride: rides.values()) {
            if (ride.isAvailable()) {
                availableRides.add(ride);
            }
        }
        return availableRides;
    }

    public boolean isEmpty() {
        return rides.size() == 0 ;
    }

}
