package main.models.spots;

import main.models.SpotType;
import main.models.spots.Spot;

public class CarSpot extends Spot {
    public CarSpot(Integer localId) {
        super(localId, SpotType.CAR);
    }
}
