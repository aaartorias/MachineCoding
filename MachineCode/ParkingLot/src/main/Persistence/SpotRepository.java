package main.Persistence;

import main.Model.Floor;
import main.Model.Spot;
import main.interfaces.repository.ISpotRepository;
import main.interfaces.repository.Store;

public class SpotRepository extends Store<Integer, Spot> implements ISpotRepository {

    @Override
    public Spot addSpot() {
        Spot spot = new Spot();
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
