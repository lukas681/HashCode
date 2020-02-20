package com.company.IO;
import gurobi.*;

import java.util.*;
import java.util.stream.Collectors;

public class ProblemData {
    int B, L ,D;
    int[] bookScores;
    HashMap<Integer, Boolean> wasAlreadyScanned = new HashMap();
    ArrayList<Library> libraries = new ArrayList();
    boolean debug = false;
    int currentStep = 0;

    public void addFirstLine(String line) {
        String[] splitted =  line.split(" ");
        B = Integer.parseInt(splitted[0]);
        L = Integer.parseInt(splitted[1]);
        D = Integer.parseInt(splitted[2]);
        bookScores = new int[B];
    }

    public void addSecondLine(String line) { //TODO Try faster casing
       String[] splitted = line.split(" ");
       for(int i = 0; i < splitted.length; i++) {
          bookScores[i] = Integer.parseInt(splitted[i]);
       }
    }
    public void addDataSet(String firstLine, String secondLine, int libraryID) {
        String[] splitted = firstLine.split(" ");
        if(debug) {
            System.out.println("1:" +firstLine);
            System.out.println("2:" +secondLine);
        }
        String[] splitted2 = secondLine.split(" ");
        List<Integer> books = Arrays.stream(splitted2)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Library l = new Library(Integer.valueOf(splitted[0]), 
                Integer.valueOf(splitted[1]), 
                Integer.valueOf(splitted[2]), 
                books, libraryID);
        libraries.add(l);
    }

    public void setDebugOn() {
        debug=true;
    }
    public Solution solve() {
        Solution s = new Solution();
        // First step schedule libraries
        PriorityQueue <Library> scoreForlibraries = new PriorityQueue<Library>(new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                return o1.calculateScore() < o2.calculateScore()?-1:1;
            }
        });

        for(int i = 0; i < D; i ++) {
            try {
                GRBEnv env = new GRBEnv();
                GRBModel model = new GRBModel(env);

                GRBLinExpr expr = new GRBLinExpr();
                List<GRBVar> vars = new ArrayList();
                for(int y  = 0; i < bookScores.length; y++ ) {
                    if(wasAlreadyScanned.get(i)!=true){
                        vars.add(model.addVar(0.0,1.0,0.0, GRB.BINARY, "B"+ String.valueOf(y));
                        expr.addTerm(1/bookScores[y],); //TODO Not finished yet.
                    }
                }
                model.setObjective(expr, GRB.MAXIMIZE);
           //TODOO Update already scanned books
             } catch (GRBException e) {
                e.printStackTrace();
            }
        }
        // Start the simulation
        s.addLibrary(libraries.get(1), libraries.get(1).getBooksHere());
        System.out.println("Solving Complete!");
        return s;
    }
}
