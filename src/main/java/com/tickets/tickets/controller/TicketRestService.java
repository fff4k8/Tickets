package com.tickets.tickets.controller;

import com.tickets.tickets.dao.TicketDao;
import com.tickets.tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketRestService {
    @Autowired
    private TicketDao ticketDao;


    @RequestMapping(value = "/{routeId}/available", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Ticket> getAvailableTickets(@PathVariable Long routeId) {
        return ticketDao.getAvailableTicketsByRoute(routeId);
    }

    @RequestMapping(value = "/{routeId}/purchased", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Ticket> getPurchasedTickets(@PathVariable Long routeId) {
        return ticketDao.getPurchasedTicketsByRoute(routeId);
    }


    @RequestMapping(value = "/{routeId}/buyticket/{ticketId}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody
    Ticket buyTicket(@RequestBody Ticket ticket, @PathVariable Long routeId, @PathVariable int ticketId) {
        ticketDao.buyTicket(routeId, ticket, ticketId);
        return ticket;
    }

}
