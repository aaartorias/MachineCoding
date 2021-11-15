package main.java.com.database;

import main.java.com.exceptions.DriverAlreadyExistsException;
import main.java.com.exceptions.DriverNotFoundException;
import main.java.com.model.User;

import java.util.HashMap;

public class UsersManager {
    private HashMap<String, User> users;

    public UsersManager() {
        users = new HashMap<>();
    }

    public void addUser(User driver) throws DriverAlreadyExistsException {
        if (users.containsKey(driver.getName())) {
            throw new DriverAlreadyExistsException();
        }
        users.put(driver.getName(),driver);
    }

    public HashMap<String, User> getUser() {
        return users;
    }

    public User getUser(String name) throws DriverNotFoundException {
        if (!users.containsKey(name)) {
            throw new DriverNotFoundException();
        }
        return users.get(name);
    }

}
