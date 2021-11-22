package com.techelevator;

import  java.util.Calendar;

public class Movie extends Media{

    public Movie(String title, Calendar startDate, String genre) {
        super(title, startDate, genre);
    }

    public Movie(String title, Calendar startDate, String genre, Calendar endDate) {
        super(title, startDate, genre, endDate);
    }

    @Override
    public String toString() {
        try {
            return "title: " + getTitle() + " start: " + displayStartDate() + " genre: " + getGenre() + " end: " + displayEndDate() + " complete: " + isComplete() + "\n";
        } catch (NullPointerException e) {
            return "title: " + getTitle() + " start: " + displayStartDate() + " genre: " + getGenre() + " end: N/A" + " complete: " + isComplete() + "\n";
        }
    }
}