package main.java.com.model;

public class User {
    private String name;
    private char gender;
    private int age;
    private Integer ridesTaken;
    private Integer ridesOffered;

    public User(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        ridesOffered = 0;
        ridesTaken = 0;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Integer getRidesTaken() {
        return ridesTaken;
    }

    public Integer getRidesOffered() {
        return ridesOffered;
    }

    public void addRidesTaken() {
        ridesTaken = ridesTaken + 1;
    }

    public void addRidesOffered() {
        ridesOffered = ridesOffered + 1;
    }

    public String toString() {
        return "User [age=" + age + ", gender=" + gender + ", name=" + name + "]";
    }

}
