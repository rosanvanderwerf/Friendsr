package com.example.rosan.friendsr;

import java.io.Serializable;

/* Created by rosan on 21-2-2018. */

public class Friend implements Serializable {
    private String name;
    private String bio;
    private int drawableId;
    private float rating;

    public Friend(String name, String bio, Integer drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setRating(float rating) { this.rating = rating; }
}

