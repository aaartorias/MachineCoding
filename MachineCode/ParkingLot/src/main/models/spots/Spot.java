package main.models.spots;

import main.models.SpotStatus;
import main.models.SpotType;
import main.models.VehicleType;

public class Spot {
    private Integer spotId;
    private static Integer counter = 0;
    private SpotStatus status;
    private Integer localId;
    private SpotType spotType;

    public Spot(Integer localId, SpotType spotType) {
        this.spotId = ++counter;
        this.status = SpotStatus.EMPTY;
        this.localId = localId;
        this.spotType = spotType;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public void vehicleAssigned() {
        if (status == SpotStatus.EMPTY) {
            status = SpotStatus.ASSIGNED;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void freeSpot() {
        if (status == SpotStatus.ASSIGNED || status == SpotStatus.UNAVAILABLE) {
            status = SpotStatus.EMPTY;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean isEmpty() {
        return status == SpotStatus.EMPTY;
    }

    public SpotStatus getStatus() { return status;}

    public SpotType getSpotType() {
        return  spotType;
    }

    public Integer getLocalId() {
        return localId;
    }

    public boolean isAssigned() {
        return status == SpotStatus.ASSIGNED;
    }

    public boolean isUnavailable() {
        return status == SpotStatus.UNAVAILABLE;
    }
}
