package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private HashMap<Integer, Floor> floors; // TODO: replace map with arraylist

    public ParkingLot() {
        floors = new HashMap<>();
    }

    public HashMap<Integer, Floor> getFloors() {
        return floors;
    }

    public void addFloors(Integer floorId) {
        Floor newFloor = new Floor(floorId);
        floors.put(floorId,newFloor);
    }
}
