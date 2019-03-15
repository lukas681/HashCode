package com.hashcode.model;

import java.util.ArrayList;
import java.util.List;

public class FleetFactory {
    /**
     * Creates a Car fleet
     * @param n
     * @return
     */
    public static List<Car> create(int n){
        List<Car> fleet = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            fleet.add(new Car());
        }
        return fleet;
    }
}
