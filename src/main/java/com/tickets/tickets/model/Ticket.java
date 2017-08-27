package com.tickets.tickets.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String firstname;
    private String lastname;
    private boolean purchased;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Route route;

    public Ticket() {
    }

    public Ticket(Route route) {
        this.route = route;
    }

    public Ticket(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

}
