package com.company;

import com.company.IO.Loader;
import com.company.IO.ProblemData;
import com.company.IO.Solution;
import com.company.IO.Writer;
import gurobi.GRBException;

public class Main {

    public static void main(String[] args) throws GRBException {
        Loader l = new Loader();
        String[] files = new String[] {
               // "res/a_example.txt",
                "res/b_read_on.txt",
                "res/c_incunabula.txt",
                "res/d_tough_choices.txt",
                "res/f_libraries_of_the_world.txt",
        };

        for(String s: files) {
            System.out.println(s);
            ProblemData solv = l.loadData(s);
            System.out.println("Data Succesfully loaded");
            Solution solution = solv.solve();
            Writer w = new Writer();
            w.write(solution, s);
        }
    }
}
