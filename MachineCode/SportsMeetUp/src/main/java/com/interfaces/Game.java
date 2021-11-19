package main.java.com.interfaces;

import java.util.ArrayList;

public abstract class Game {
    private String name;
    private Integer seatsAvailable;
    private ArrayList<User> players;
    private final Integer offeredSeats;
    private Integer id;
    private static Integer counter = 0;
    private Integer startTime;
    private Integer endTime;
    private User creator;
    private String location;
    private Status status;

    public Game(String name, Integer totalSeats, User creator, Integer startTime, Integer endTime, String location) {
        this.creator = creator;
        this.name = name;
        this.seatsAvailable = totalSeats-1;
        this.offeredSeats = totalSeats-1;
        this.id = ++counter;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.status = Status.NEW;
        this.players = new ArrayList<>();
        this.players.add(creator);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public void updateSeats(Integer seats) {
        this.seatsAvailable = seats;
    }

    public ArrayList<User> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<User> players) {
        this.players = players;
    }

    public Integer getId() {
        return id;
    }

    public void addPlayer(User player) {
        players.add(player);
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public Game getSport() {
        return this;
    }

    public String getLocation() {
        return location;
    }

    public boolean isActive() {
        return (status == Status.BOOKING_ACTIVE || status == Status.NEW) ;
    }

    public void startBooking() {
        status = Status.BOOKING_ACTIVE;
    }

    public void startGame() {
        status = Status.IN_PROGRESS;
    }

    public void endGame() {
        status = Status.FINISHED;
    }

    public void bookSeats(Integer seatsRequested) {
        this.seatsAvailable = this.seatsAvailable-seatsRequested;
    }

    public Integer getOfferedSeats() {
        return offeredSeats;
    }
}

enum Status {
    NEW,
    BOOKING_ACTIVE,
    IN_PROGRESS,
    FINISHED;
}