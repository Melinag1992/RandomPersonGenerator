package com.example.c4q.exam.model;



import java.io.Serializable;
import java.util.List;

/**
 * Created by c4q on 1/24/18.
 */

public class Results implements Serializable{
    private Name name;
    private Location location;
    private String email;
    private String dob;
    private String cell;
    private Picture picture;

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getCell() {
        return cell;
    }

    public Picture getPicture() {
        return picture;
    }
}
