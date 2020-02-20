package com.company.IO;

import java.io.*;

public class Loader {

    /**
     *
     * @param filename
     * @return Problem
     */
    public ProblemData loadData(String filename) {
        ProblemData pd = new ProblemData();
        String csvFile = filename;
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            pd.addFirstLine(br.readLine());
            pd.addSecondLine(br.readLine());
            int libraryID = 0;
            while((line = br.readLine()) != null){

                if(!line.equals(""))
                    pd.addDataSet(line, br.readLine(), libraryID++);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pd;
    }
}
