package com.company.IO;

import com.company.Photo;
import com.company.SlideShow;

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
            System.out.println(s.getSlideShow().size());
            for(Photo[] p: s.getSlideShow()){
                if(p.length == 1){ //Horizontal
                    writer.write("" + p[0].getId());
                } else { // Vertical
                    writer.write(p[0] + " " + p[1].getId());
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Writer tw = new Writer();

        ArrayList<String> exTags = new ArrayList<>();
        exTags.add("a");
        SlideShow sl = new SlideShow();
        sl.addHorizontal(new Photo("H","123",new ArrayList<String>()));
        sl.addHorizontal(new Photo("H","123",new ArrayList<String>()));
        sl.addHorizontal(new Photo("H","123",new ArrayList<String>()));
        sl.addHorizontal(new Photo("H","123",new ArrayList<String>()));

        tw.writeSlideShow(sl);
    }
}
