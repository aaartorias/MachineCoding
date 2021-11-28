package main.models;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Floor> floors;
    private Integer id;

    public ParkingLot(Integer id) {
        this.id = id;
        this.floors = new ArrayList<>();
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
