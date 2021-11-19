package main.java.com.interfaces;

import main.java.com.interfaces.observers.IGameObserver;

public class User implements IUser{
    private String name;
    private String email;
    private String phone;
    private Integer id;
    private static Integer counter = 0;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        id = ++counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return " :: User ID: " + getId()+ " Name: " +getName();
    }

}
