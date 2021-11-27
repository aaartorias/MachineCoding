package main.java.com.databases;

import main.java.com.exceptions.DriverAlreadyExistsException;
import main.java.com.exceptions.DriverNotFoundException;
import main.java.com.models.User;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
// Stores mapping <license,User>
public class DriversManager {
    private HashMap<String, User> drivers;

    public DriversManager() {
        drivers = new HashMap<>();
    }

    public void addDriver(@NotNull User driver) throws DriverAlreadyExistsException {
        if (drivers.containsKey(driver.getName())) {
            throw new DriverAlreadyExistsException();
        }
        drivers.put(driver.getName(),driver);
    }

    public HashMap<String, User> getRiders() {
        return drivers;
    }

    public User getDriver(String name) throws DriverNotFoundException {
        if (!drivers.containsKey(name)) {
            throw new DriverNotFoundException();
        }
        return drivers.get(name);
    }

    public boolean driverExists(String name) {
        if (drivers.containsKey(name))
            return true;
        return false;
    }

}
