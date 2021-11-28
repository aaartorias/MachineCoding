package main.interfaces.repository;

import main.models.ParkingLot;

public interface IParkingLotRepository {
    ParkingLot getParkingLot(Integer id);
    ParkingLot createParking(Integer parkingLotId);
}
