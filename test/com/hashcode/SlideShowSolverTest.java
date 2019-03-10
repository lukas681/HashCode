package com.hashcode;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SlideShowSolverTest {

    SlideShowSolver solv = new SlideShowSolver();

    @Test
    public void calcScore() {

        ArrayList<String> tags1  = new ArrayList<>();
        ArrayList<String> tags2  = new ArrayList<>();

        tags1.add("123");
        tags1.add("234");
        tags1.add("345");
        tags1.add("456");

        tags2.add("123");
        tags2.add("234");
        tags2.add("987");
        tags2.add("876");

        Photo a = new Photo("H","0",tags1);
        Photo b = new Photo("H","1",tags2);

        assertTrue(solv.calcScore(a, a) == 0);
        assertTrue(solv.calcScore(b, b) == 0);
        assertTrue(solv.calcScore(a,b) == 2);

        tags1.add("677");
        tags1.add("1237");

        assertTrue(solv.calcScore(a, b) == 2);
    }
}