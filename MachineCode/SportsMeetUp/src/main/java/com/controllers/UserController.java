package main.java.com.controllers;

import main.java.com.interfaces.User;
import main.java.com.persistence.UserStore;

import java.util.ArrayList;

public class UserController {
    private UserStore userStore;
    private final ObserverController observerController;

    public UserController(UserStore userStore, ObserverController observerController) {
        this.userStore = userStore;
        this.observerController = observerController;
    }

    // create user
    public User createUser(String name, String email, String phone) {
        User user = userStore.addUser(name,email,phone);
        return user;
    }

    // get user info - logged in user
    public User getUserById(Integer id) {
        return userStore.get(id);
    }

    public ArrayList<User> getAllUsers() {
        return userStore.getUsers();
    }

    // update user info

    //
}
