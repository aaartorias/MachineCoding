package main.java.com.interfaces;

import java.util.ArrayList;

public interface IGameStore {
    Game addGame(User creator, Integer startTime, Integer endTime, String location, Integer seats);
    Game addGame(User creator, Integer startTime, Integer endTime, String location);
    Game getGame(Integer id);
    ArrayList<Game> getGames();
}
