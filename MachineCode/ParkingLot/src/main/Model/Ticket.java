package Model;

enum Status {
    NEW,
    ASSIGNED,
    COLLECTED
}

public class Ticket {
    private Integer id;
    private Status status;
    private static Integer counter = 0;

    public Ticket() {
        status = Status.NEW;
        this.id = counter++;
    }

    public Integer getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void ticketAssigned() {
        status = Status.ASSIGNED;
    }

    public void ticketCollected() {
        status = Status.COLLECTED;
    }
}
