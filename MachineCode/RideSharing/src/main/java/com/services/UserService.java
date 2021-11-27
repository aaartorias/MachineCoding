package main.java.com.services;

import main.java.com.databases.UsersManager;
import main.java.com.exceptions.UserAlreadyExistsException;
import main.java.com.models.User;

public class UserService {
    private UsersManager usersManager;
    public UserService(UsersManager usersManager) {
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
