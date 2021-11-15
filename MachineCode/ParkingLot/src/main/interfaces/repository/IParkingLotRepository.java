package main.interfaces.repository;

import main.Model.ParkingLot;

public interface IParkingLotRepository {
    void addParkingLot(Integer id, ParkingLot parkingLot );
    ParkingLot getParkingLot(Integer id);

}
