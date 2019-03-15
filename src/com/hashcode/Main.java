package com.hashcode;

import com.hashcode.model.Solver;
import com.hashcode.model.SolverImpl;

public class Main {

    public static void main(String[] args) {
        Solver solver = new SolverImpl();
        solver.solve("res/qualification_round_2018.in/a_example.in","output_1.txt");
        solver.solve("res/qualification_round_2018.in/b_should_be_easy.in","output_2.txt");
        solver.solve("res/qualification_round_2018.in/c_no_hurry.in","output_3.txt");
        solver.solve("res/qualification_round_2018.in/d_metropolis.in","output_4.txt");
        solver.solve("res/qualification_round_2018.in/e_high_bonus.in","output_5.txt");

    }
}
