package main.java.com.interfaces.observable;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.observers.IGameObserver;

public interface IGameObservable {
    void registerUser(IGameObserver user);
    void deregisterUser(IGameObserver user);
    void notifySubscribers();
    void update(Game game);
}
