package main.persistence;

import main.models.Floor;
import main.interfaces.repository.IFloorRepository;
import main.interfaces.repository.Store;

public class FloorRepository extends Store<Integer,Floor> implements IFloorRepository {

    @Override
    public Floor addFloor(Integer floorId) {
        Floor floor = new Floor(floorId);
        add(floor.getId(),floor);
        return floor;
    }

    @Override
    public Floor getFloor(Integer floorId) {
        return null;
    }
}
