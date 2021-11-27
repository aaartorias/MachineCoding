package main.java.com.databases;

import main.java.com.exceptions.RiderAlreadyExistsException;
import main.java.com.exceptions.RiderNotFoundException;
import main.java.com.models.User;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
// Stores mapping <name,User> for riders
public class PassengersManager {
    private HashMap<String, User> riders;

    public PassengersManager() {
        riders = new HashMap<>();
    }

    public void addRider(@NotNull User rider) throws RiderAlreadyExistsException {
        if (riders.containsKey(rider.getName())) {
            throw new RiderAlreadyExistsException();
        }
        riders.put(rider.getName(),rider);
    }

    public HashMap<String, User> getRiders() {
        return riders;
    }

    public User getRider(String name) throws RiderNotFoundException {
        if (!riders.containsKey(name)) {
            throw new RiderNotFoundException();
        }
        return riders.get(name);
    }

    public boolean riderExists(String name) {
        if (riders.containsKey(name))
            return true;
        return false;
    }

    public void removeRiders(ArrayList<User> riders) {
        for (User rider: riders) {
            riders.remove(rider.getName());
        }
    }
}
