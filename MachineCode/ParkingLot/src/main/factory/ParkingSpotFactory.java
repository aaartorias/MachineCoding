package main.factory;

import main.models.spots.BikeSpot;
import main.models.spots.CarSpot;
import main.models.spots.Spot;
import main.models.spots.TruckSpot;

public class ParkingSpotFactory {

    public Spot createSpot(int localId) {
        Spot spot;
        if (localId  == 1) {
            spot = new TruckSpot(localId);
        } else if (localId == 2 || localId == 3) {
            spot = new BikeSpot(localId);
        } else {
            spot = new CarSpot(localId);
        }
        return spot;
    }
}
