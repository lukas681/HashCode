package com.company;

import com.company.IO.Loader;
import com.company.IO.Writer;
import com.company.TSP.TspDynamicProgrammingIterative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class SlideShowSolver {

    ArrayList<Photo> photos;
    boolean[] visited = new boolean[photos.size()];

    Loader l = new Loader();
    Writer w = new Writer();
    SlideShow sl = new SlideShow();


    // TODO Refactor code!!
    public void solve() {
        photos = l.loadData("res/b_lovely_landscapes.txt"," ");
        restructure();
        int CUTAT = 10000, maxScore = 0;

            // ArrayList<Photo> cluster = photos.stream().
               //     filter(x -> x.getNumTags() == finalI).collect(Collectors.toCollection(ArrayList::new));
        for(int i = 0; i < CUTAT; i+=25){ // We will ignore those images at a specific threshold.
            maxScore = 0; // Maximal Score for one element in photo ds
            Photo maxPhoto = null;
            if(visited[i]){

            }
            for(int y = i; y < photos.size(); y++){
                int score = calcScore(photos.get(i), photos.get(y));
                if(score > maxScore){
                    maxScore = score;
                    maxPhoto = photos.get(y);
                }
            }
            System.out.println(i + " " +maxScore);
        }
        }

    public int calcScore(Photo a, Photo b) {

        int numberOfIntersectingElements = a.tags.stream().filter(c -> b.tags.contains(c)).collect(Collectors.toList()).size();
        return Math.min(Math.min(a.tags.size()-numberOfIntersectingElements,b.tags.size()-numberOfIntersectingElements), numberOfIntersectingElements);
    }

    public void restructure(){
        photos.sort((o1, o2) -> o2.getNumTags() - o1.getNumTags());

    }

}
