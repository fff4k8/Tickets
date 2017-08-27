package com.tickets.tickets.controller;

import com.tickets.tickets.TicketsApplication;
import com.tickets.tickets.dao.RouteDao;
import com.tickets.tickets.model.Route;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TicketsApplication.class)

public class RouteRestServiceTest {
    private MockMvc mockMvc;

    @Autowired
    private RouteRestService routeRestService;

    @Autowired
    private RouteDao routeDao;

    private Route route;

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(routeRestService).build();
        route = new Route("spb", "msk");
        routeDao.save(route);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test

    public void findRouteById_ShouldReturnRouteObjectWithCurrentId() throws Exception {

        mockMvc.perform(get("/routes/{routeId}", route.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("id").value(route.getId()));

    }


}