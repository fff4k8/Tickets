package com.tickets.tickets.controller;

import com.tickets.tickets.dao.RouteDao;
import com.tickets.tickets.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteRestService {
    @Autowired
    private RouteDao routeDao;


    @RequestMapping(value = "/routes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Route> findRoutesByDate(@RequestParam(value = "date", defaultValue = "today") String date) {
        List<Route> list = routeDao.findRoutesByDate(date);
        return list;

    }

    @RequestMapping(value = "/routes/{routeId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Route findRouteById(@PathVariable Long routeId) {

        return routeDao.findById(routeId);
    }


    @RequestMapping(value = "/routes", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody
    Route addRoute(@RequestBody Route route) {
        routeDao.save(route);
        return route;
    }


    @RequestMapping(value = "/allroutes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Route> findAllRoutes() {
        return routeDao.findAllRoutes();

    }


}
