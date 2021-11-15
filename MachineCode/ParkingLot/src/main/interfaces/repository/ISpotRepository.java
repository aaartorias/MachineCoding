package main.interfaces.repository;

import main.Model.Floor;
import main.Model.Spot;

public interface ISpotRepository {
    Spot addSpot();
    Spot getSpot(Integer spotId);
}
