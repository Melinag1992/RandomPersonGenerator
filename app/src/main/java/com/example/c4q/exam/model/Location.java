package com.example.c4q.exam.model;

import java.io.Serializable;

/**
 * Created by c4q on 1/24/18.
 */

public class Location implements Serializable{
    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    private String city;
    private String state;
    private int postcode;

}
