package com.hashcode.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Simulation {

    private final int simulationDuration;
    SimulationTime time;

    /**
     Rides list is a time series.
      */
    ArrayList<Ride> rides;
    List<Car> fleet;
    final int maximalDistance;

    public Simulation(ArrayList<Ride> rides, int simulationDuration, City c, int fleetSize) {
        this.rides = rides;
        rides.sort(Comparator.comparingInt(Ride::getEarliestStart));
        this.simulationDuration = simulationDuration;
        maximalDistance = c.getMaximumDistance();
        time = new SimulationTime();
        fleet = FleetFactory.create(fleetSize);
    }


    public void startSimulation() {
       while(time.getTime() < simulationDuration) {
           System.out.println("STEP: +++ " + time.getTime() +" +++");
           nextStep();
           time.increment();
       }
    }

    public void nextStep() {
        List<Car> freeCars = getFreeCars();
        List<Ride> nextPossibleRides = rides.stream().
                filter(x -> x.getEarliestStart() > time.getTime()
                        && x.getEarliestStart() < time.getTime() + maximalDistance)
                .collect(Collectors.toList());
        for(Car c: freeCars) {
            Ride r  = c.findBestRide(nextPossibleRides, time);
            removeRideFromList(r);
            nextPossibleRides.remove(r);
            if(r != null)
                c.assignRide(r);
        }
        moveCars();
    }

    private void moveCars() {
        fleet.forEach(x->x.move());
    }

    /**
     * Removes a Ride form the time series ride list
     * @param r
     */
    private void removeRideFromList(Ride r) {
       rides.remove(r);
    }

    public List<Car> getFleet() {
        return fleet;
    }
    public List<Car> getFreeCars() {
        return fleet.stream().filter(x->x.isFree()).collect(Collectors.toList());

    }
}
