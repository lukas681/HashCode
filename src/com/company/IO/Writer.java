package com.company.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Writer {
    public void write(Solution s, String fileName) {

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
            writer.write(""+ s.getUsedLibraries().size());
            writer.newLine();

            Map<Library, List<Integer>> sol = s.getUsedLibraries();
            for(Map.Entry<Library, List<Integer>> x: sol.entrySet()) //TODO: Does it prevent order?
            {
                writer.write(x.getKey().libraryID+" " + x.getValue().size());
                writer.newLine();
                //O(n^2...)
                String l = "";
                for(int i = 0; i < x.getValue().size(); i++) {
                   l+= x.getValue().get(i) +" ";
                }
                writer.write(l);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
