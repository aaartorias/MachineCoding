package main.persistence;

import main.models.ParkingLot;
import main.interfaces.repository.IParkingLotRepository;
import main.interfaces.repository.Store;

public class ParkingLotRepository extends Store<Integer, ParkingLot> implements IParkingLotRepository {

    @Override
    public ParkingLot getParkingLot(Integer id) {
        return get(id);
    }

    @Override
    public ParkingLot createParking(Integer parkingLotId) {
        ParkingLot parkingLot = new ParkingLot(parkingLotId);
        add(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}
