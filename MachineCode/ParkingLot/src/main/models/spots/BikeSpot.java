package main.models.spots;

import main.models.SpotType;

public class BikeSpot extends Spot {
    public BikeSpot(Integer localId) {
        super(localId, SpotType.BIKE);
    }
}
