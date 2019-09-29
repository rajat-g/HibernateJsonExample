package com.example.demo.model;

import java.io.Serializable;

public class Location implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4159031826189859L;

	private String country;

    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}