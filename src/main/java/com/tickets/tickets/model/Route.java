package com.tickets.tickets.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String location;
    private String destination;
    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ticket> tickets = generateTickets();

    public Route() {
    }

    public Route(String location, String destination) {
        this.location = location;
        this.destination = destination;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    private List<Ticket> generateTickets() {
        List<Ticket> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Ticket(this));
        }
        return list;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", destination='" + destination + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
