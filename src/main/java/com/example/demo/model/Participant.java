package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Participant")
@Table(name = "participant")
public class Participant extends BaseEntity {
 
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Ticket ticket;
 
    @ManyToOne
    private Event event;
 
    public Ticket getTicket() {
        return ticket;
    }
 
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
 
    public Event getEvent() {
        return event;
    }
 
    public void setEvent(Event event) {
        this.event = event;
    }
}