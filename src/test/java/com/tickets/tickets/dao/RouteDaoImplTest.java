package com.tickets.tickets.dao;

import com.tickets.tickets.TicketsApplication;
import com.tickets.tickets.model.Route;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TicketsApplication.class)

public class RouteDaoImplTest {
    @Autowired
    private RouteDao routeDao;
    private Route route;


    @Before
    public void setUp() throws Exception {
        route = new Route( "spb", "msk");

    }

    @After
    public void tearDown() throws Exception {

    }



    @Test
    public void save_ShouldPersistEntity() throws Exception {
        String date = "25";
        route.setDate(date);
        routeDao.save(route);
        assertThat(routeDao.findRoutesByDate(date).get(0),notNullValue(Route.class));
    }

}