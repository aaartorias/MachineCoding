package main.java.com.controllers;

import main.java.com.GameObservable;
import main.java.com.interfaces.Game;
import main.java.com.interfaces.observable.IGameObservable;

public class ObservableController {

    public void addObservable(Game cricket) {
        IGameObservable gameObservable = new GameObservable();
    }
}
