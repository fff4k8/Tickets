package com.tickets.tickets.dao;

import com.tickets.tickets.TicketsApplication;
import com.tickets.tickets.model.Route;
import com.tickets.tickets.model.Ticket;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TicketsApplication.class)
public class TicketDaoImplTest {


@Autowired
private TicketDao ticketDao;
@Autowired
private RouteDao routeDao;
private Ticket ticket;
private Route route;


    @Before
    public void setUp() throws Exception {
        route = new Route("msk","spb");
        ticket = new Ticket("alex", "pavlov");
        routeDao.save(route);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void buyTicket_SavesEntityAndGetsPurchased() throws Exception {
        ticketDao.buyTicket(route.getId(), ticket, 1);
        assertEquals(!route.getTickets().get(0).isPurchased(), true);
    }

}
