package com.hashcode.model;

public class Ride {
    int id;
    int[] startCoordinates;
    int[] stopCoordinates;
    int earliestStart;
    int latestFinish;

    public Ride(int id, int[] startCoordinates, int[] stopCoordinates, int earliestStart, int latestFinish) {
        this.id = id;
        this.startCoordinates = startCoordinates;
        this.stopCoordinates = stopCoordinates;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public int getRideDuration () {
        return Math.abs(startCoordinates[0]- startCoordinates[1]) + Math.abs(stopCoordinates[0] + stopCoordinates[1]);
    }

    public int[] getStartCoordinates() {
        return startCoordinates;
    }

    public void setStartCoordinates(int[] startCoordinates) {
        this.startCoordinates = startCoordinates;
    }

    public int[] getStopCoordinates() {
        return stopCoordinates;
    }

    public void setStopCoordinates(int[] stopCoordinates) {
        this.stopCoordinates = stopCoordinates;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    public int getId() {
        return id;
    }
}
