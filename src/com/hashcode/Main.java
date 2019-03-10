package com.hashcode;

import com.hashcode.model.Solver;
import com.hashcode.model.SolverImpl;

public class Main {

    public static void main(String[] args) {
        Solver solver = new SolverImpl();
        solver.solve();
    }
}
