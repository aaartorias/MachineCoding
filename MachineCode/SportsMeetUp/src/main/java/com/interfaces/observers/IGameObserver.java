package main.java.com.interfaces.observers;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.IUser;

public interface IGameObserver extends IUser {
     void subscribe();
     void unSubscribe();
     boolean bookSeat(int seats);
     void update(Game game);
}
