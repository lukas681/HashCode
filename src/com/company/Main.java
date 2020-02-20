package com.company;

import com.company.IO.Loader;
import com.company.IO.ProblemData;
import com.company.IO.Writer;
import gurobi.GRBException;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws GRBException {
        Loader l = new Loader();
        String[] files = new String[] {
                "res/a_example.in",
                "res/b_small.in",
                "res/c_medium.in",
                "res/d_quite_big.in",
                "res/e_also_big.in",
        };

        for(String s: files) {
            ProblemData solv = l.loadData(s, " ");
            solv.solve();
            Writer w = new Writer();
            w.write(solv, s);
        }
    }
}
