package com.hashcode.model;

import com.hashcode.io.Loader;
import com.hashcode.io.LoaderImpl;
import com.hashcode.io.Writer;
import com.hashcode.io.WriterImpl;

public class SolverImpl implements Solver {

    Loader l = new LoaderImpl();
    Writer w = new WriterImpl();
    DataModel dm = new DataModel();

    @Override
    public void solve() {
        // TODO Load Data
        //      = l.loadData("res/b_lovely_landscapes.txt", " ");
        final String INPUT_FILENAME = "xxxxxxxxxxxxx";
        final String DELIM = " ";
        dm = l.loadData(INPUT_FILENAME, DELIM);
        dm.solveProblem();
        w.write(dm);
    }


}
