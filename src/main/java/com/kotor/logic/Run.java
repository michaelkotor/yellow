package com.kotor.logic;

import org.springframework.stereotype.Component;

@Component
public class Run {
    private int distance;
    private int time;
    private String date;

    public Run(int distance, int time, String date) {
        this.distance = distance;
        this.time = time;
        this.date = date;
    }

    public Run() {}

    @Override
    public String toString() {
        return "distance: " + this.distance + "\n" +
        "time: " + this.time + "\n" +
                "date: " + date;
    }
}
