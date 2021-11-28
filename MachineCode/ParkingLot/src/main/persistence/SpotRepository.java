package main.persistence;

import main.models.spots.Spot;
import main.interfaces.repository.ISpotRepository;
import main.interfaces.repository.Store;
import main.factory.ParkingSpotFactory;

public class SpotRepository extends Store<Integer, Spot> implements ISpotRepository {

    ParkingSpotFactory parkingSpotFactory;

    public SpotRepository(ParkingSpotFactory parkingSpotFactory) {
        this.parkingSpotFactory = parkingSpotFactory;
    }

    @Override
    public Spot addSpot(Integer localId) {
        Spot spot = parkingSpotFactory.createSpot(localId);
        add(spot.getSpotId(),spot);
        return spot;
    }

    @Override
    public Spot getSpot(Integer spotId) {
        return get(spotId);
    }

    public Spot getFreeSpot() {
        for (Spot spot: list()) {
            if (spot.isEmpty()) return spot;
        }
        return null;
    }

}
