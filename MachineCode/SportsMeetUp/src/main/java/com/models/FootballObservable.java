package main.java.com.models;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.observable.IGameObservable;
import main.java.com.interfaces.observers.IGameObserver;

import java.util.ArrayList;

public class FootballObservable implements IGameObservable {
    private ArrayList<IGameObserver> subscribers;

    public FootballObservable() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void registerUser(IGameObserver user) {
        subscribers.add(user);
    }

    @Override
    public void deregisterUser(IGameObserver user) {
        subscribers.remove(user);
    }

    @Override
    public void notifySubscribers() {

    }
}
