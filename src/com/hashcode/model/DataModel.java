package com.hashcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * For efficiency: We will not create an interface for that, because
 * API can often change during contest
 */
public class DataModel {

    ArrayList<Ride> rides = new ArrayList<>();
    Simulation simulation;

    public void addData(ArrayList<String[]> data) {
        String[] firstLine = data.get(0);
        data.remove(0);
        for(String[] singleRide: data) {
            rides.add(new Ride(data.indexOf(singleRide), new int[]{ Integer.valueOf(singleRide[0]), Integer.valueOf(singleRide[1])} ,
                    new int[] {Integer.valueOf(singleRide[2]), Integer.valueOf(singleRide[3])},
                    Integer.valueOf(singleRide[4]), Integer.valueOf(singleRide[5])));
      } // Index of can be improve
    int columns = Integer.valueOf(firstLine[0]);
    int rows = Integer.valueOf(firstLine[1]);
    int fleetSize = Integer.valueOf(firstLine[2]);
     simulation = new Simulation(rides, Integer.valueOf(firstLine[5]), new City(columns, rows), fleetSize);
    }

    public void solveProblem() {
        simulation.startSimulation();
        // Simulation get Cars...

        System.out.println("Successfully loaded " + rides.size() + " datasets");
    };

    public List<String> generateOutput() {
        List<String> output = new ArrayList<>();
        List<Car> fleet = simulation.getFleet();
        for(Car c: fleet) {
            String line = ""+fleet.indexOf(c);
            for(Integer i : c.getAssignedRideIDs()){
                line +=" " + i;
            }
            output.add(line);
        }
        return output;
    }

}
