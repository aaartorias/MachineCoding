package Model;

import java.util.HashMap;

public class Floor {
    private Integer floorId;
    private HashMap<Integer, Spot> spots;
    public Floor(int floorId) {
        this.floorId = floorId;
        spots = new HashMap<>();
    }
    public void addSpots(Integer id) {
        Spot spot = new Spot(id);
        spots.put(id,spot);
    }
}
