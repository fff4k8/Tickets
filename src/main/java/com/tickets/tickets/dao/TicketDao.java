package com.tickets.tickets.dao;

import com.tickets.tickets.model.Ticket;

import java.util.List;

public interface TicketDao {

    void buyTicket(Long routeId, Ticket ticket, int ticketId);

    List<Ticket> getAvailableTicketsByRoute(Long routeId);

    List<Ticket> getPurchasedTicketsByRoute(Long routeId);

}
