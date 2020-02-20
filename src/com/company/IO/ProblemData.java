package com.company.IO;

import com.sun.media.sound.InvalidDataException;
import gurobi.*;

import java.util.ArrayList;
import java.util.List;


public class ProblemData {
    boolean isSolved = false;
    private int maxSlices, numberOfUsedPizzas;
    private int[] pizzaTypes;
    private int[] pizzaSolution;

    public void addFirstLine(String line) {
        String[] splitted =  line.split(" ");
        maxSlices = Integer.parseInt(splitted[0]);
        int numTypes = Integer.parseInt(splitted[1]);
        pizzaTypes = new int[numTypes];
        pizzaSolution = new int[numTypes];
    }

    public void solve() throws GRBException {
        GRBEnv env = new GRBEnv("out/log.txt");
        GRBModel model = new GRBModel(env);
        GRBLinExpr expr = new GRBLinExpr();

        List<GRBVar> vars = new ArrayList();
        for(int i: pizzaTypes) {
            vars.add(model.addVar(0.0, 1.0, 0.0, GRB.BINARY, String.valueOf(i)));
            expr.addTerm(i, vars.get(vars.size()-1));
        }
        model.setObjective(expr, GRB.MAXIMIZE);
        model.addConstr(expr, GRB.LESS_EQUAL, maxSlices, "c0");

        model.optimize();
        for(int i = 0; i < vars.size(); i++) {
            pizzaSolution[i] = (int) vars.get(i).get(GRB.DoubleAttr.X);
            if(pizzaSolution[i] != 0) {
                numberOfUsedPizzas++;
            }
        }
        isSolved = true;
    }
    public void addLine(String line) {
        String[] splitted = line.split(" ");
        for(int i = 0; i < splitted.length; i++) {
            pizzaTypes[i] = Integer.parseInt(splitted[i]);
        }
    }

    public int getNumUsedPizzas() {
       return numberOfUsedPizzas;
    }

    public int[] getPizzaValues() throws InvalidDataException {
        if(isSolved) {
          return pizzaSolution;
        } else{
            throw new InvalidDataException();
        }
    }
}
