package main.java.com;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.observable.IGameObservable;
import main.java.com.interfaces.observers.IGameObserver;

import java.util.ArrayList;

public class GameObservable implements IGameObservable {
    ArrayList<IGameObserver> subscribers;
    Game game;

    public GameObservable() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void update(Game game) {
        this.game = game;
        notifySubscribers();
    }

    @Override
    public void registerUser(IGameObserver observer) {
        subscribers.add(observer);
    }

    @Override
    public void deregisterUser(IGameObserver observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (IGameObserver subscriber: subscribers) {
            //subscriber.
            subscriber.update(game);
        }
    }
}
