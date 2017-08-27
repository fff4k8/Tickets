package com.tickets.tickets.dao;

import com.tickets.tickets.model.Route;
import com.tickets.tickets.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void buyTicket(Long routeId, Ticket ticket, int ticketId) {
        Session session = sessionFactory.openSession();
        Route route = session.get(Route.class, routeId);
        Ticket dbticket = route.getTickets().get(ticketId - 1);
        dbticket.setFirstname(ticket.getFirstname());
        dbticket.setLastname(ticket.getLastname());
        dbticket.setPurchased(true);

        session.beginTransaction();
        session.update(dbticket);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Ticket> getAvailableTicketsByRoute(Long routeId) {
        Session session = sessionFactory.openSession();
        Route route = session.get(Route.class, routeId);
        List<Ticket> list = route.getTickets();
        List<Ticket> avaliableTickets = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Ticket ticket = list.get(i);
            if (!ticket.isPurchased()) {
                avaliableTickets.add(ticket);
            }
        }
        return avaliableTickets;
    }

    @Override
    public List<Ticket> getPurchasedTicketsByRoute(Long routeId) {
        Session session = sessionFactory.openSession();
        Route route = session.get(Route.class, routeId);
        List<Ticket> list = route.getTickets();
        List<Ticket> purchasedTickets = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Ticket ticket = list.get(i);
            if (ticket.isPurchased()) {
                purchasedTickets.add(ticket);
            }
        }
        return purchasedTickets;
    }


}
