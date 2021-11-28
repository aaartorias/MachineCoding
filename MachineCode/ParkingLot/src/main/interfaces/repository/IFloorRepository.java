package main.interfaces.repository;

import main.models.Floor;

public interface IFloorRepository {
    Floor addFloor(Integer floorId);
    Floor getFloor(Integer floorId);
}
