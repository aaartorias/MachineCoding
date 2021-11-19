package main.java.com.persistence;

import main.java.com.interfaces.IGameStore;
import main.java.com.interfaces.Game;
import main.java.com.interfaces.Store;
import main.java.com.interfaces.User;
import main.java.com.models.Cricket;

import java.util.ArrayList;

public class CricketStore extends Store<Integer, Game> implements IGameStore {
    @Override
    public Game addGame(User creator, Integer startTime, Integer endTime, String location, Integer seats) {
        Game cricket = new Cricket(creator, startTime, endTime, location, seats);
        add(cricket.getId(),cricket);
        return cricket;
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
