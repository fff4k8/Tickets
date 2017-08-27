package com.tickets.tickets.dao;

import com.tickets.tickets.model.Route;

import java.util.List;

public interface RouteDao {
List<Route> findRoutesByDate(String date);
    List<Route> findAllRoutes();
    void save(Route route);
    Route findById(Long id);

}
