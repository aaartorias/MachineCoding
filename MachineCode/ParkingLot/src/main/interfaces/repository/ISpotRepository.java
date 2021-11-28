package main.interfaces.repository;

import main.models.spots.Spot;

public interface ISpotRepository {
    Spot addSpot(Integer localId);
    Spot getSpot(Integer spotId);
}
