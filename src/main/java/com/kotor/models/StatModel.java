package com.kotor.models;

import java.util.Date;

public class StatModel {
    private Date start;
    private Date finish;
    private double speedAv;
    private double timeAv;
    private double totalDistance;

    public StatModel(Date start, Date finish, double speedAv, double timeAv, double totalDistance) {
        this.start = start;
        this.finish = finish;
        this.speedAv = speedAv;
        this.timeAv = timeAv;
        this.totalDistance = totalDistance;
    }
}
