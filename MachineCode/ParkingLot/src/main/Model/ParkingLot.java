package main.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private ArrayList<Floor> floors;
    private Integer id;
    //private static Integer counter = 0;

    public ParkingLot(Integer id) {
        id = id;
        floors = new ArrayList<>();
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public Integer getId() {
        return id;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }
}
