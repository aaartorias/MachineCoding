package main.java.com.persistence;

import main.java.com.interfaces.IUserRepository;
import main.java.com.interfaces.Store;
import main.java.com.interfaces.User;

import java.util.ArrayList;

public class UserStore extends Store<Integer,User> implements IUserRepository {

    @Override
    public User addUser(String name, String email, String phone) {
        User user = new User(name, email, phone);
        add(user.getId(),user);
        return user;
    }

    @Override
    public User getUser(Integer id) {
        return get(id);
    }

    public ArrayList<User> getUsers() { return list();}
}
