package main.java.com.models;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;

public class Cricket extends Game {

    public Cricket(User creator, Integer startTime, Integer endTime, String location) {
        super("cricket", 11,creator, startTime, endTime, location );
    }
    public Cricket(User creator, Integer startTime, Integer endTime, String location, Integer seats) {
        super("cricket", seats, creator, startTime, endTime, location );
    }

}
