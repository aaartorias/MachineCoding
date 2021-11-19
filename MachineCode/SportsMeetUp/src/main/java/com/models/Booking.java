package main.java.com.models;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;
import java.util.ArrayList;

public class Booking {
    private ArrayList<User> players;
    private Integer bookingId;
    private static Integer counter = 0;
    private Game game;
    private Integer seats;

    public Booking(User user, Game game, int seatsRequested)  {
        this.game = game;
        this.players = new ArrayList<>();
        this.players.add(user);
        this.bookingId = ++counter;
        this.seats = seatsRequested;
    }

    public ArrayList<User> getPlayers() {
        return players;
    }

    public void addPlayer(User player) {
        players.add(player);
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public Game getSport() {
        return game;
    }

    public Game getGame() {
        return game;
    }
}
