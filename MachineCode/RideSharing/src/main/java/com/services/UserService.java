package main.java.com.services;

import main.java.com.persistence.UsersRepository;
import main.java.com.exceptions.UserAlreadyExistsException;
import main.java.com.models.User;

public class UserService {
    private UsersRepository usersRepository;
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void addUser(String name, char gender, int age) throws UserAlreadyExistsException {
        User user = new User(name,gender,age);
        usersRepository.addUser(user);
    }

    public void printStats() {
        for (User user: usersRepository.getAllUsers()) {
            System.out.println(user.getName() + " : " + user.getRidesTaken() + " Taken, "
                    + user.getRidesOffered() + " Offered");
        }
    }
}
