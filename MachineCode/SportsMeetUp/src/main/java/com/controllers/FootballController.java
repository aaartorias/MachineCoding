package main.java.com.controllers;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;
import main.java.com.models.FootBall;
import main.java.com.persistence.FootballStore;
import main.java.com.persistence.UserStore;

import java.util.ArrayList;

public class FootballController {
    FootballStore footballStore;
    UserStore userStore;
    ObservableController observableController;

    public FootballController(FootballStore footballStore, UserStore userStore,
                              ObservableController observableController) {
        this.footballStore = footballStore;
        this.userStore = userStore;
        this.observableController = observableController;
    }

    public FootBall createGame(Integer creatorId, Integer startTime, Integer endTime, String location) {
        User creator = userStore.getUser(creatorId);
        FootBall footBall = (FootBall) footballStore.addGame(creator, startTime, endTime, location);
        return footBall;
    }

    public FootBall createGame(Integer creatorId, Integer startTime, Integer endTime, String location, Integer seats) {
        User creator = userStore.getUser(creatorId);
        FootBall footBall = (FootBall) footballStore.addGame(creator, startTime, endTime, location, seats);
        return footBall;
    }

//    public ArrayList<FootBall> getGames() {
//        ArrayList<FootBall> allGames =  (ArrayList<FootBall>) ((ArrayList<?>) footballStore.getGames());
//        return  allGames;
//    }

    public ArrayList<Game> getGames() {
        return  footballStore.getGames();
    }

    public FootBall getGameById(Integer id) {
        return (FootBall) footballStore.getGame(id);
    }

    public Integer getSeats(Integer gameId) {
        return footballStore.get(gameId).getSeatsAvailable();
    }


    public ArrayList<Game> getAvailableGames() {
        ArrayList<Game> games = new ArrayList<>();
        for(Game game: footballStore.getGames()) {
            if (game.isActive()) {
                games.add(game);
            }
        }
        return games;
    }
}
