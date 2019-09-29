package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "Event")
@Table(name = "event")
public class Event extends BaseEntity {
 
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Location location;
 
    public Location getLocation() {
        return location;
    }
 
    public void setLocation(Location location) {
        this.location = location;
    }
}