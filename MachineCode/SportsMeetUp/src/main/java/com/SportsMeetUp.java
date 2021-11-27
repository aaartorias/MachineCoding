package main.java.com;

import main.java.com.controllers.*;
import main.java.com.exceptions.BookingFullException;
import main.java.com.exceptions.RequestedSeatsNotAvailableException;
import main.java.com.interfaces.Game;
import main.java.com.interfaces.User;
import main.java.com.models.Booking;
import main.java.com.persistence.BookingStore;
import main.java.com.persistence.CricketStore;
import main.java.com.persistence.FootballStore;
import main.java.com.persistence.UserStore;

import java.util.ArrayList;

public class SportsMeetUp {

    private BookingStore bookingStore;
    private FootballStore footballStore;
    private CricketStore cricketStore;
    private UserStore userStore;
    private BookingController bookingController;
    private FootballController footballController;
    private CricketController cricketController;
    private UserController userController;
    private ObservableController observableController;
    private ObserverController observerController;

    public void initialize() {
        bookingStore = new BookingStore();
        footballStore = new FootballStore();
        cricketStore = new CricketStore();
        userStore = new UserStore();
        observableController = new ObservableController();
        observerController = new ObserverController();
        bookingController = new BookingController(bookingStore, observableController);
        footballController = new FootballController(footballStore, userStore, observableController);
        cricketController = new CricketController(cricketStore, userStore, observableController);
        userController = new UserController(userStore, observerController);
    }

    public Integer book(Integer requesterId, Integer seatsRequested, String gameType ,Integer gameId) {
        Booking booking = null;
        User requester = userController.getUserById(requesterId);
        Game game = null;
        if (gameType.toLowerCase() == "football") {
            game = footballController.getGameById(gameId);
        } else if (gameType.toLowerCase() == "cricket") {
            game = cricketController.getGameById(gameId);
        }

        try {
            booking = bookingController.createBooking(requester, game, seatsRequested);
            return booking.getBookingId();
        } catch (BookingFullException e) {
            //e.printStackTrace();
            System.out.print(e.toString());
            System.out.println(requester.toString());
        } catch (RequestedSeatsNotAvailableException e) {
           // e.printStackTrace();
            System.out.println(e.toString());
        }
        return -1;
    }

    public Integer addNewUser(String name, String email, String phone) {
        User user = userController.createUser(name, email, phone);
        return user.getId();
    }

    public Integer createNewGame(String type, Integer creatorId, Integer startTime, Integer endTime, String location, Integer seats) {
        Game game = null ;
        if (type.toLowerCase() == "football") {
            game = createFootballGame(creatorId, startTime, endTime, location, seats);
        } else if (type.toLowerCase() == "cricket") {
            game = createCricketGame(creatorId, startTime, endTime, location, seats);
        }
        return game.getId();
    }

    private Game createCricketGame(Integer creatorId, Integer startTime, Integer endTime, String location, Integer seats) {
        Game cricket = null;
        if (seats == null) {
            cricket = (Game) cricketController.createGame(creatorId, startTime, endTime, location);
        } else {
            cricket = (Game) cricketController.createGame(creatorId, startTime, endTime, location, seats);
        }
        return cricket;
    }

    private Game createFootballGame(Integer creatorId, Integer startTime, Integer endTime, String location, Integer seats) {
        Game football = null;
        if (seats == null) {
            football = (Game) footballController.createGame(creatorId, startTime, endTime, location);
        } else {
            football = (Game) footballController.createGame(creatorId, startTime, endTime, location, seats);
        }
        return football;
    }

    public void printAllGames() {
        printFootball();
        printCricket();
    }

    public void printFootball() {
        ArrayList<Game> allFootballGames = footballController.getGames();
        printGames(allFootballGames);
    }

    public void printCricket() {
        ArrayList<Game> allCricketGames = cricketController.getGames();
        printGames(allCricketGames);
    }

    private void printGames(ArrayList<Game> games) {
        if (games.isEmpty()) return;
        System.out.println("Id " + " Game " + "     Location "
                + "   Start Time " + "    End Time " + "    Offered Seats" + "    Remaining Seats" );
        for (Game game : games) {
            System.out.println(
                    game.getId() + "   " + game.getName() +  "   " + game.getLocation() + "        "
                    + game.getStartTime() + "             " + game.getEndTime() + "             "
                    + game.getOfferedSeats() +"               " + game.getSeatsAvailable()
            );
        }
    }
    //TODO: 1) make PrintCricket(), printFootball(), printAllAvailableFootballGames()
    // and printAllAvailableCricketGames() private
    // 2) add a flog to control frequency of printing of Header in PrintGames method
    // 3) expose public print methods to print specific game
    public void printAllAvailableGames() {
        printAllAvailableFootballGames();
        printAllAvailableCricketGames();
    }

    public void printAllAvailableFootballGames() {
        ArrayList<Game> allAvailableFootballGames = footballController.getAvailableGames();
        printGames(allAvailableFootballGames);
    }

    public void printAllAvailableCricketGames() {
        ArrayList<Game> allAvailableCricketGames = cricketController.getAvailableGames();
        printGames(allAvailableCricketGames);
    }
}
