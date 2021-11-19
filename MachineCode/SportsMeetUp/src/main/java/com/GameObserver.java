package main.java.com;

import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;
import main.java.com.interfaces.observable.IGameObservable;
import main.java.com.interfaces.observers.IGameObserver;

public class GameObserver implements IGameObserver {
    private IGameObservable publisher;
    private User user;

    public GameObserver(IGameObservable publisher, User user) {
        this.publisher = publisher;
        this.user = user;
    }

    @Override
    public void subscribe() {
        publisher.registerUser(this);
    }

    @Override
    public void unSubscribe() {
        publisher.deregisterUser(this);
    }

    @Override
    public boolean bookSeat(int seats) {
        return false;
    }

    @Override
    public void update(Game game) {
        System.out.println("Notification: New game available---");
        System.out.println("Id " + " Game " + "     Location "
                + "   Start Time " + "    End Time " + "    Offered Seats" + "    Remaining Seats" );
        System.out.println(
                game.getId() + "   " + game.getName() +  "   " + game.getLocation() + "        "
                + game.getStartTime() + "             " + game.getEndTime() + "             "
                + game.getOfferedSeats() +"               " + game.getSeatsAvailable()
        );
    }
}
