package com.example.c4q.exam.model;

import java.io.Serializable;

/**
 * Created by c4q on 1/24/18.
 */

public class Size implements Serializable{
    private String large;
    private String medium;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    private String thumbnail;

}
