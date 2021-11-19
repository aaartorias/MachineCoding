package main.java.com.controllers;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;
import main.java.com.models.Cricket;
import main.java.com.persistence.CricketStore;
import main.java.com.persistence.UserStore;

import java.util.ArrayList;

public class CricketController {
    CricketStore cricketStore;
    UserStore userStore;
    ObservableController observableController;

    public CricketController(CricketStore cricketStore, UserStore userStore,
                             ObservableController observableController) {
        this.cricketStore = cricketStore;
        this.userStore = userStore;
        this.observableController = observableController;
    }

    public Cricket createGame(Integer creatorId, Integer startTime, Integer endTime, String location, Integer seats) {
        User creator = userStore.getUser(creatorId);
        Cricket cricket = (Cricket) cricketStore.addGame(creator, startTime, endTime, location, seats);
        return cricket;
    }

    public Cricket createGame(Integer creatorId, Integer startTime, Integer endTime, String location) {
        User creator = userStore.getUser(creatorId);
        Cricket cricket = (Cricket) cricketStore.addGame(creator, startTime, endTime, location);
        return cricket;
    }

//    public ArrayList<Cricket> getGames() {
//        ArrayList<Cricket> allGames =  (ArrayList<Cricket>) ((ArrayList<?>) cricketStore.getGames());
//        return  allGames;
//    }

    public ArrayList<Game> getGames() {
        return  cricketStore.getGames();
    }

    public Cricket getGameById(Integer id) {
        return (Cricket) cricketStore.getGame(id);
    }

    public Integer getSeats(Integer gameId) {
        return cricketStore.get(gameId).getSeatsAvailable();
    }

    public ArrayList<Game> getAvailableGames() {
        ArrayList<Game> games = new ArrayList<>();
        for(Game game: cricketStore.getGames()) {
            if (game.isActive()) {
                games.add(game);
            }
        }
        return games;
    }
}
