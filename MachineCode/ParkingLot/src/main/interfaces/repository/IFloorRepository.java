package main.interfaces.repository;

import main.Model.Floor;
import main.Model.ParkingLot;

import java.util.ArrayList;

public interface IFloorRepository {
    Floor addFloor(Integer floorId);
    Floor getFloor(Integer floorId);
}
