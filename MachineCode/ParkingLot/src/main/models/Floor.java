package main.models;

import main.models.spots.Spot;

import java.util.ArrayList;

public class Floor {
    private  Integer id;
    private static Integer counter = 0;
    private ArrayList<Spot> spots;
    private Integer localId;
    int capacity;

    public Floor(Integer localId) {
        this.id = counter++;
        this.spots = new ArrayList<>();
        this.localId = localId;
    }
    public Integer getId() {
        return id;
    }

    public void addSpot(Spot spot) {
         spots.add(spot);
    }

    public ArrayList<Spot> getAllFreeSpots() {
        ArrayList<Spot> freeSpots = new ArrayList<>();
        for (Spot spot : spots) {
            if (spot.isEmpty()) {
                freeSpots.add(spot);
            }
        }
        return  freeSpots;
    }

    public ArrayList<Spot> getAllFreeSpots(SpotType spotType) {
        ArrayList<Spot> freeSpots = new ArrayList<>();
        for (Spot spot : spots) {
            if (spotType == spot.getSpotType() && spot.isEmpty()) {
                freeSpots.add(spot);
            }
        }
        return  freeSpots;
    }

    public Spot getFirstFreeSpot(SpotType spotType) {
        Spot freeSpot = null;
        for (Spot spot : spots) {
            if (spotType == spot.getSpotType() && spot.isEmpty()) {
                freeSpot = spot ;
            }
        }
        return freeSpot;
    }

    public Integer getLocalId() {
        return localId;
    }

    public ArrayList<Spot> getAllOccupiedSpots(SpotType spotType) {
        ArrayList<Spot> freeSpots = new ArrayList<>();
        for (Spot spot : spots) {
            if (spotType == spot.getSpotType() && (spot.isAssigned() || spot.isUnavailable())) {
                freeSpots.add(spot);
            }
        }
        return  freeSpots;
    }
}
