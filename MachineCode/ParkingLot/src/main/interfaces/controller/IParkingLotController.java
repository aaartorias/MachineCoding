package main.interfaces.controller;

import main.models.Floor;
import main.models.spots.Spot;

import java.util.ArrayList;

public interface IParkingLotController {
    void createParkingLot();
    ArrayList<Floor> getAvailableFloors();
    Spot getFirstAvailableSpot();
    ArrayList<Spot> getAllAvailableSpots();
}
