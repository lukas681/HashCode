package com.company.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void write(ProblemData pd, String fileName) {

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
            writer.write(String.valueOf(pd.getNumUsedPizzas()));
            writer.newLine();
            int[] pv = pd.getPizzaValues();
            for(int i = 0; i < pv.length; i++){
                    if(pv[i]!=0) {
                        writer.write(i + " ");
                    }
            }
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
