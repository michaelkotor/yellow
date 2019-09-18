package com.kotor.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RunModel {
    private long id;
    private String username;
    private double distance;
    private double time;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public RunModel(long id, String username, double distance, double time, Date date) {
        this.id = id;
        this.username = username;
        this.distance = distance;
        this.time = time;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }


    public double getDistance() {
        return distance;
    }


    public double getTime() {
        return time;
    }
}
