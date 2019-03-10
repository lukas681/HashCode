package com.hashcode.io;

import com.hashcode.model.DataModel;

import java.io.*;
import java.util.ArrayList;

public class LoaderImpl implements Loader {

    public DataModel loadData(String filename, String delim) {
        String csvFile = filename;
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = delim;
        DataModel dm = new DataModel();
        ArrayList<String> tags;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                dm.addData(line.split(csvSplitBy));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dm;
    }
}
