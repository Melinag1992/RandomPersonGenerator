package com.example.c4q.exam.model;

import java.util.HashMap;

/**
 * Created by c4q on 1/24/18.
 */

public class User {

    public HashMap<Name, String> getName() {
        return name;
    }

    public void setName(HashMap<Name, String> name) {
        this.name = name;
    }

    public HashMap<Location, String> getLocation() {
        return location;
    }

    public void setLocation(HashMap<Location, String> location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public HashMap<Size, String> getPicture() {
        return picture;
    }

    public void setPicture(HashMap<Size, String> picture) {
        this.picture = picture;
    }

    private HashMap<Name,String> name;
    private HashMap<Location,String> location;
    private String email;
    private String dob;
    private String cell;
    private HashMap<Size,String> picture;


}
