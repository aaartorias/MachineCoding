package main.Persistence;

import main.Model.Floor;
import main.Model.ParkingLot;
import main.interfaces.repository.IFloorRepository;
import main.interfaces.repository.IStore;
import main.interfaces.repository.Store;

import java.util.ArrayList;
import java.util.HashMap;

public class FloorRepository extends Store<Integer,Floor> implements IFloorRepository {

    @Override
    public Floor addFloor(Integer floorId) {
        Floor floor = new Floor();
        add(floor.getId(),floor);
        return floor;
    }

    @Override
    public Floor getFloor(Integer floorId) {
        return null;
    }
}
