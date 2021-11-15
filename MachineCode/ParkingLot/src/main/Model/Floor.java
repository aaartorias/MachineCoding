package main.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Floor {
    private  Integer id;
    private static Integer counter = 0;
    private ArrayList<Spot> spots;
    int capacity;

    public Floor() {
        this.id = counter++;
        spots = new ArrayList<>();
    }
    public Integer getId() {
        return id;
    }

    public void addSpots(Spot spot) {
         spots.add(spot);
    }
}
