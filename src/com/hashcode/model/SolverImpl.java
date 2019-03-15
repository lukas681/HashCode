package com.hashcode.model;

import com.hashcode.io.Loader;
import com.hashcode.io.LoaderImpl;
import com.hashcode.io.Writer;
import com.hashcode.io.WriterImpl;

public class SolverImpl implements Solver {

    final String DELIM = " ";

    Loader l = new LoaderImpl();
    Writer w = new WriterImpl();
    DataModel dm = new DataModel();

    @Override
    public void solve(String filename, String outputfile) {
        dm = l.loadData(filename, DELIM);
        dm.solveProblem();
        w.write(dm, outputfile);
    }


}
