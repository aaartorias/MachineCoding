package main.java.com.models;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;

public class FootBall extends Game {
    public FootBall(User creator, Integer startTime, Integer endTime, String location) {
        super("football", 11,creator, startTime, endTime, location );
    }
    public FootBall(User creator, Integer startTime, Integer endTime, String location, Integer seats) {
        super("football", seats, creator, startTime, endTime, location );
    }
}
