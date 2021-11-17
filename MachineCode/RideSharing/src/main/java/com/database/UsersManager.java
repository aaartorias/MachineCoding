package main.java.com.database;

import main.java.com.exceptions.DriverNotFoundException;
import main.java.com.exceptions.UserAlreadyExistsException;
import main.java.com.models.User;

import java.util.Collection;
import java.util.HashMap;

public class UsersManager {
    private HashMap<String, User> users;

    public UsersManager() {
        users = new HashMap<>();
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        if (users.containsKey(user.getName())) {
            throw new UserAlreadyExistsException();
        }
        users.put(user.getName(),user);
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

    public Collection<User> getAllUsers() {
        return users.values();
    }

}
