package main.Persistence;

import main.Model.Ticket;
import main.interfaces.repository.ITicketRepository;
import main.interfaces.repository.Store;

public class TicketRepository extends Store<Integer,Ticket> implements ITicketRepository {
    @Override
    public Ticket getTicket(Integer id) {
        return get(id);
    }

    @Override
    public Ticket addTicket() {
        Ticket ticket = new Ticket();
        add(ticket.getId(),ticket);
        return ticket;
    }

    @Override
    public void assignTicket(Integer id) {
        Ticket ticket = get(id);
        ticket.assign();
    }

    @Override
    public void collectTicket(Integer id) {
        Ticket ticket = get(id);
        ticket.collect();
    }

}
