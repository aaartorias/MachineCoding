package main.Model;

enum Status {
    NEW,
    ASSIGNED,
    COLLECTED
}

public class Ticket {
    private Integer id;
    private Status status;
    private static Integer counter = 0;
    private Spot spot;
    private Vehicle vehicle;

    public Ticket() {
        status = Status.NEW;
        this.id = ++counter;
    }

    public Integer getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void assign() {
        status = Status.ASSIGNED;
    }

    public void collect() {
        status = Status.COLLECTED;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
