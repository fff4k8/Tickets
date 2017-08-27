package com.tickets.tickets.dao;

import com.tickets.tickets.model.Route;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteDaoImpl implements RouteDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Route> findRoutesByDate(String date) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Route.class)
                .add(Restrictions.eq("date", date));
        List<Route> list = criteria.list();
        session.close();
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Route> findAllRoutes() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Route.class);
        List<Route> list = criteria.list();

        return list;
    }

    @Override
    public void save(Route route) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(route);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Route findById(Long id) {
        Session session = sessionFactory.openSession();
        Route route = session.get(Route.class, id);
        Hibernate.initialize(route.getTickets());
        session.close();
        return route;
    }


}
