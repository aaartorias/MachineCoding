package main.java.com.models;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.observable.IGameObservable;
import main.java.com.interfaces.observers.IGameObserver;

public class FootballObserver implements IGameObserver {
    private IGameObservable footballPublisher;

    public FootballObserver(IGameObservable publisher) {
        footballPublisher = publisher;
    }

    @Override
    public void subscribe() {
        footballPublisher.registerUser(this);
    }

    @Override
    public void unSubscribe() {
        footballPublisher.deregisterUser(this);
    }

    @Override
    public boolean bookSeat(int seats) {
        return false;
    }

    @Override
    public void update(Game game) {

    }
}
