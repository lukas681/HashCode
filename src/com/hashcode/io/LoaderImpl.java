package com.hashcode.io;

import com.hashcode.model.DataModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoaderImpl implements Loader {

    public DataModel loadData(String filename, String delim) {
        String csvFile = filename;
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = delim;
        DataModel dm = new DataModel();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            ArrayList<String[]> data = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                data.add(line.split(csvSplitBy));
            }
            dm.addData(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dm;
    }
}
