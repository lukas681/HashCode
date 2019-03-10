package com.company.IO;

import com.company.Photo;

import java.io.*;
import java.util.ArrayList;

public class Loader {

    public ArrayList<Photo>  loadData(String filename, String delim) {
        String csvFile = filename;
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = delim;
        ArrayList<Photo> ar = new ArrayList<>();
        ArrayList<String> tags;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            int count = 0;

            br.readLine();
            while((line = br.readLine()) != null){

                String[] photo = line.split(csvSplitBy);

                // Adding all Tags
                tags = new ArrayList<>();
                for (int i = 2; i < photo.length; i++) {
                    tags.add(photo[i]);
                }
                ar.add(new Photo(photo[0], String.valueOf(count), tags));
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ar;


    }

    public static void main(String[] args) {
        Loader l = new Loader();
        ArrayList<Photo> ar = l.loadData("res/b_lovely_landscapes.txt"," ");
        System.out.println("Test");
    }
}
