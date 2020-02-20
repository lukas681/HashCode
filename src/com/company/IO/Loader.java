package com.company.IO;

import java.io.*;

public class Loader {

    /**
     *
     * @param filename
     * @param delim
     * @return Problem
     */
    public ProblemData loadData(String filename, String delim) {
        ProblemData pd = new ProblemData();
        String csvFile = filename;
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = delim;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            pd.addFirstLine(br.readLine());

            while((line = br.readLine()) != null){
                pd.addLine(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pd;
    }
}
