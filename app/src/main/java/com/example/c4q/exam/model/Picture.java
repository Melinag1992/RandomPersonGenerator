package com.example.c4q.exam.model;

import java.io.Serializable;

/**
 * Created by c4q on 1/24/18.
 */

public class Picture implements Serializable {

    private String large;
    private String medium;
    private String thumbnail;

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}