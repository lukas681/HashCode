package com.company.IO;

import java.util.List;

public class Library {
    int libraryID;
    private int numberOfBooks;
    private int booksPerDay;
    private int signupDuration;
    private int getLibraryID;

    public int getIsBusy() {
        return isBusy;
    }

    public void setIsBusy(int isBusy) {
        this.isBusy = isBusy;
    }

    private int isBusy;

    private double c1 = 1, c2 = 1, c3 = 1;
    private List<Integer> booksHere;


    public Library(Integer numberOfBooks, Integer signupDuration, Integer booksPerDay, List<Integer> books, int libraryID) {
        this.numberOfBooks = numberOfBooks;
        this.signupDuration = signupDuration;
        this.booksPerDay = booksPerDay;
        this.booksHere = books;
        this.libraryID = libraryID;
    }


    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public List<Integer> getBooksHere() {
        return booksHere;
    }

    public void setBooksHere(List<Integer> booksHere) {
        this.booksHere = booksHere;
    }
    public int getSignupDuration() {
        return signupDuration;
    }

    public void setSignupDuration(int signupDuration) {
        this.signupDuration = signupDuration;
    }

    public int getBooksPerDay() {
        return booksPerDay;
    }

    public void setBooksPerDay(int booksPerDay) {
        this.booksPerDay = booksPerDay;
    }

    public double calculateScore() {
       return (booksHere.size() / signupDuration) * booksPerDay * (c1 * c2 * c3);
    }
}
