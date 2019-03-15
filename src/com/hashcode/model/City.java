package com.hashcode.model;

public class City {
    int columns;
    int rows;

    public City(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public int getMaximumDistance () {
        return columns * rows;
    }
}