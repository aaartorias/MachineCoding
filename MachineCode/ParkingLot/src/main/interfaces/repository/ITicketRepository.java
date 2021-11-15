package main.interfaces.repository;

import main.Model.Ticket;

public interface ITicketRepository {
    Ticket getTicket(Integer id);
    Ticket addTicket();
    void assignTicket(Integer id);
    void collectTicket(Integer id);
}
