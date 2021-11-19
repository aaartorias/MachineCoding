package main.java.com.persistence;

import main.java.com.interfaces.IGameStore;
import main.java.com.interfaces.Game;
import main.java.com.interfaces.Store;
import main.java.com.interfaces.User;
import main.java.com.models.Cricket;
import main.java.com.models.FootBall;

import java.util.ArrayList;

public class FootballStore extends Store<Integer, Game> implements IGameStore {

    @Override
    public Game addGame(User creator, Integer startTime, Integer endTime, String location, Integer seats) {
        Game football = new FootBall(creator, startTime, endTime, location, seats);
        add(football.getId(),football);
        return football;
    }

    @Override
    public Game addGame(User creator, Integer startTime, Integer endTime, String location) {
        Game cricket = new Cricket(creator, startTime, endTime, location);
        add(cricket.getId(),cricket);
        return cricket;
    }

    @Override
    public Game getGame(Integer id) {
        return get(id);
    }

    @Override
    public ArrayList<Game> getGames() {
        return list();
    }

}
