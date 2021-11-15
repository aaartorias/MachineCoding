package main.Persistence;

import main.Model.ParkingLot;
import main.interfaces.repository.IParkingLotRepository;
import main.interfaces.repository.Store;

public class ParkingLotRepository extends Store<Integer, ParkingLot> implements IParkingLotRepository {

    @Override
    public void addParkingLot(Integer id, ParkingLot parkingLot ) {
        add(id,parkingLot);
    }

    @Override
    public ParkingLot getParkingLot(Integer id) {
        return get(id);
    }
}
