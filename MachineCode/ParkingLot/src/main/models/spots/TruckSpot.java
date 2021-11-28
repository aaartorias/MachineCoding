package main.models.spots;

import main.models.SpotType;

public class TruckSpot extends Spot {
    public TruckSpot(Integer localId) {
        super(localId, SpotType.TRUCK);
    }
}
