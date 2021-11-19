package test.java.com;

import main.java.com.SportsMeetUp;
import main.java.com.exceptions.BookingFullException;
import main.java.com.exceptions.RequestedSeatsNotAvailableException;
import main.java.com.interfaces.User;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMatch {
    static HashMap<String,Integer> nameIdMap = new HashMap<>();
    static HashMap<Integer,Integer> userGameId = new HashMap<>();
    static HashMap<Integer,String> gameIds = new HashMap<>();
    static HashMap<Integer,Integer> bookingIdToGameIdMap = new HashMap<>();

    public static void main(String[] args)
            throws BookingFullException, RequestedSeatsNotAvailableException {

        SportsMeetUp sportsMeetUp = new SportsMeetUp();
        sportsMeetUp.initialize();

        addUsers(sportsMeetUp);
        createFootballGames(sportsMeetUp);
        createCricketGames(sportsMeetUp);
        createCricketBookings(sportsMeetUp);

        sportsMeetUp.printAllAvailableGames();

        createFootballBookings(sportsMeetUp);
        sportsMeetUp.printAllGames();
    }

    private static void createBooking(SportsMeetUp sportsMeetUp, String creator
            , String requester, Integer seatsRequested)
            throws BookingFullException, RequestedSeatsNotAvailableException {

        Integer bookingId;
        Integer creatorId;
        Integer gameId;
        Integer requesterId;
        String gameType;

        creatorId = nameIdMap.get(creator);
        gameId = userGameId.get(creatorId);
        gameType = gameIds.get(gameId);
        requesterId = nameIdMap.get(requester);
        bookingId = sportsMeetUp.book(requesterId,seatsRequested,gameType, gameId);
        bookingIdToGameIdMap.put(bookingId,gameId);
    }

    private static void createCricketBookings(SportsMeetUp sportsMeetUp)
            throws BookingFullException, RequestedSeatsNotAvailableException {

        createBooking(sportsMeetUp,"Launchpad", "Webby", 2);
        createBooking(sportsMeetUp,"Launchpad", "Louie", 1);
        createBooking(sportsMeetUp,"Launchpad", "Hue", 1);
        createBooking(sportsMeetUp,"Launchpad", "Due", 1);
        createBooking(sportsMeetUp,"Launchpad", "Gyro", 2);
    }

    private static void createFootballBookings(SportsMeetUp sportsMeetUp)
            throws BookingFullException, RequestedSeatsNotAvailableException {
        createBooking(sportsMeetUp,"Flintheart", "Beakely", 1);
        createBooking(sportsMeetUp,"Flintheart", "Darkwing Duck", 1);
        createBooking(sportsMeetUp,"Flintheart", "Scrooge", 1);
        createBooking(sportsMeetUp,"Flintheart", "Doofus", 1);
        createBooking(sportsMeetUp,"Flintheart", "Shinchan", 5);
    }

    private static void createCricketGames(SportsMeetUp sportsMeetUp) {
        Integer launchpad = nameIdMap.get("Launchpad");
        Integer gameId = sportsMeetUp.createNewGame("cricket",launchpad
                , 2, 3, "Duckberg", 4);
        gameIds.put(gameId, "cricket");
        userGameId.put(launchpad,gameId);
    }

    private static void createFootballGames(SportsMeetUp sportsMeetUp) {
        Integer flintheart = nameIdMap.get("Flintheart");
        Integer gameId = sportsMeetUp.createNewGame("football",flintheart,
                5, 6, "Money Bin", 5);
        gameIds.put(gameId, "football");
        userGameId.put(flintheart,gameId);
    }

    private static void addUsers(SportsMeetUp sportsMeetUp) {
        Integer id;

        id = sportsMeetUp.addNewUser("Launchpad", "Launchpad@vmail.com", "12345");
        nameIdMap.put("Launchpad",id);
        id = sportsMeetUp.addNewUser("Louie", "Louie@vmail.com", "12345");
        nameIdMap.put("Louie",id);
        id = sportsMeetUp.addNewUser("Hue", "Hue@vmail.com", "45678");
        nameIdMap.put("Hue",id);
        id = sportsMeetUp.addNewUser("Due", "Due@vmail.com", "12345");
        nameIdMap.put("Due",id);
        id = sportsMeetUp.addNewUser("Scrooge", "Scrooge@vmail.com", "45678");
        nameIdMap.put("Scrooge",id);
        id = sportsMeetUp.addNewUser("Gizmo Duck", "GizmoDuck@vmail.com", "12345");
        nameIdMap.put("Gizmo Duck",id);
        id = sportsMeetUp.addNewUser("Webby", "Webbiy@vmail.com", "45678");
        nameIdMap.put("Webby",id);
        id = sportsMeetUp.addNewUser("Doofus", "Doofus@vmail.com", "12345");
        nameIdMap.put("Doofus",id);
        id = sportsMeetUp.addNewUser("Flintheart", "Flintheart@vmail.com", "45678");
        nameIdMap.put("Flintheart",id);
        id = sportsMeetUp.addNewUser("Gyro", "Gyro@vmail.com", "12345");
        nameIdMap.put("Gyro",id);
        id = sportsMeetUp.addNewUser("Beakely", "Beakely@vmail.com", "45678");
        nameIdMap.put("Beakely",id);
        id = sportsMeetUp.addNewUser("Duckworth", "Duckworth@vmail.com", "12345");
        nameIdMap.put("Duckworth",id);
        id = sportsMeetUp.addNewUser("Shinchan", "Shinchan@vmail.com", "45678");
        nameIdMap.put("Shinchan",id);
        id = sportsMeetUp.addNewUser("Darkwing Duck", "DarkwingDuck@vmail.com", "45678");
        nameIdMap.put("Darkwing Duck",id);

    }
}
