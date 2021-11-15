package main.java.com.controllers;

import main.java.com.database.UsersManager;
import main.java.com.exceptions.DriverAlreadyExistsException;
import main.java.com.exceptions.UserAlreadyExistsException;
import main.java.com.model.User;

public class UserController {
    private UsersManager usersManager;

    public UserController(UsersManager usersManager) {
        this.usersManager = usersManager;
    }
    public void addUser(String name, char gender, int age) throws UserAlreadyExistsException {
        User user = new User(name,gender,age);
        usersManager.addUser(user);
    }

    public void printStats() {
        for (User user: usersManager.getAllUsers()) {
            System.out.println(user.getName() + " : " + user.getRidesTaken() + " Taken, "
                    + user.getRidesOffered() + " Offered");
        }
    }
}
