package main.java.com.controllers;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;
import main.java.com.persistence.GameStore;

import javax.swing.*;
import java.util.ArrayList;

public abstract class GameController {
    private ObservableController observableController;
    private GameStore gameStore;

    public GameController(GameStore gameStore, ObservableController observableController) {
        this.observableController = observableController;
        this.gameStore = gameStore;
    }

    public Game createGame(User creator, Integer startTime, Integer endTime, String location, Integer seats) {
        Game cricket = gameStore.addGame(creator, startTime, endTime, location, seats);
        observableController.addObservable(cricket);
        return cricket;
    }

    public Game createGame(User creator, Integer startTime, Integer endTime, String location) {
        Game cricket = gameStore.addGame(creator, startTime, endTime, location);
        return cricket;
    }

    public ArrayList<Game> getGames() {
        return gameStore.getGames();

    }

    public Game getGameById(Integer id) {
        return gameStore.getGame(id);
    }

    public Integer getSeats(Integer gameId) {
        return gameStore.get(gameId).getSeatsAvailable();
    }

    public ArrayList<Game> getAvailableGames() {
        ArrayList<Game> games = new ArrayList<>();
        for(Game game: gameStore.getGames()) {
            if (game.isActive()) {
                games.add(game);
            }
        }
        return games;
    }
}
