package com.company;

import com.company.IO.Loader;

import java.util.ArrayList;

public class SlideShow {

    Loader l;
    ArrayList<Photo[]> slideShow;

    public SlideShow() {
        slideShow = new ArrayList<>();
    }

    public void addHorizontal(Photo p){
        slideShow.add(new Photo[] {p});
    }

    public void addVertical(Photo p1, Photo p2) {
        slideShow.add(new Photo[] {p1, p2});
    }
    public ArrayList<Photo[]> getSlideShow() {
        return slideShow;
    }
}
