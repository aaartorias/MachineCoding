package main.Model;

public class Spot {
    private Integer spotId;
    private Size size;
    private static Integer counter = 0;
    private boolean isEmpty;

    public Spot() {
        this.spotId = ++counter;
        isEmpty = true;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void vehicleAssigned() {
        if (isEmpty == true) {
            isEmpty = false;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void vehicleUnassigned() {
        if (isEmpty == false) {
            isEmpty = true;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }

}
