package com.hashcode.io;

import com.hashcode.model.DataModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {

    public void write(DataModel s, String filename) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("res/" + filename));
            for (String line : s.generateOutput()) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
