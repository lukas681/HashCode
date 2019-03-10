package com.company;

import com.company.IO.Loader;
import com.company.IO.Writer;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SlideShowSolver {

    ArrayList<Photo> photos;
    ArrayList<ArrayList<Photo>> subSlideShows = new ArrayList<>();

    Loader l = new Loader();
    Writer w = new Writer();
    SlideShow sl = new SlideShow();

    /**
     *  Strategy: Take the first element in photo list and compare it to the n next photos.
     *  Take the one with the highest score and add both to a chain.
     */
    public void solve() {
        photos = l.loadData("res/b_lovely_landscapes.txt", " ");
        restructure();

        final int RANGE = 1000;

        while (!photos.isEmpty()) {
            ArrayList<Photo> sub = new ArrayList<>();

            if(photos.size()==1) // Problem: The same Photo can be returned
            {
                System.out.println("Last Element!");
                sub.add(photos.get(0));
                subSlideShows.add(sub);
                photos.remove(0);
                continue;
            }
            Photo bestNext = bestOfNextNAndNotVisited(RANGE);

            sub.add(photos.get(0)); // Add it to a sublist
            sub.add(bestNext);

            // Remove from original list
            photos.remove(0);
            photos.remove(bestNext);

            subSlideShows.add(sub);
        }
        System.out.println("Test for debugging");
        subSlideShows.forEach(x->x.forEach(y->sl.addHorizontal(y)));
        System.out.println("Test");
        w.writeSlideShow(sl);
    }


    public int calcScore(Photo a, Photo b) {
        int numberOfIntersectingElements = a.tags.stream().filter(c -> b.tags.contains(c)).collect(Collectors.toList()).size();
        return Math.min(Math.min(a.tags.size()-numberOfIntersectingElements,b.tags.size()-numberOfIntersectingElements), numberOfIntersectingElements);
    }

    public void restructure(){
        photos.sort((o1, o2) -> o2.getNumTags() - o1.getNumTags());
    }

    /** Start from Top and returns within the next n Photos the best one. Uses clock arithmetic
     *
     * @param n
     * @return
     */
    public Photo bestOfNextNAndNotVisited(int n){
        // What if there is no more
        int mod = photos.size()-1;
        int max = -1;
        Photo pMax = null;
        Photo p1 = photos.get(0);
        Photo p2;

        for(int i = 0; i < n; i++){
           p2 =  photos.get(i%mod+1);  // Should be a value between 1 and size and will exclude the photo at pos 0
           int score = calcScore(p1, p2);
           if(score> max) {
               max = score;
               pMax = p2;
           }
        }

        return pMax;
    }
}
