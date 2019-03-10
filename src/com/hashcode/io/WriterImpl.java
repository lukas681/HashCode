package com.hashcode.IO;

import com.hashcode.Photo;
import com.hashcode.SlideShow;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    public void writeSlideShow(SlideShow s) {

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("res/output.txt"));
            writer.write(String.valueOf(s.getSlideShow().size()));
            writer.newLine();
            //TODO Creating output
            /*for(Photo[] p: s.getSlideShow()){
                if(p.length == 1){ //Horizontal
                    // writer.write("" + p[0].getId());
                } else { // Vertical
                   //  writer.write(p[0] + " " + p[1].getId());
                }
                 writer.newLine();
            } */
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
