package main.java.com.interfaces;

import java.util.ArrayList;

public interface IGameController {
    Game createGame();
    ArrayList<Game> getGames();
    Game getGameById(Integer id);
}
