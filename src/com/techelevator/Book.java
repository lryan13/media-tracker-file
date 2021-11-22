package com.techelevator;

import java.util.Calendar;

public class Book extends Media{

    private int totalPages;
    private int pagesRead;
    private String type;

    public Book(String title, Calendar startDate, String genre, int totalPages, String type) {
        super(title, startDate, genre);
        this.totalPages = totalPages;
        this.pagesRead = 0;
        this.type = type;
    }

    public Book(String title, Calendar startDate, String genre, int totalPages, Calendar endDate, String type) {
        super(title, startDate, genre, endDate);
        this.totalPages = totalPages;
        this.pagesRead = 0;
        this.type = type;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        if (pagesRead > totalPages) {
            pagesRead = totalPages;
        }
        if (pagesRead < 0) {
            pagesRead = 0;
        }
        this.pagesRead = pagesRead;
        if (this.pagesRead == totalPages) {
            finish();
        }
    }

    public int getPagesLeft() {
        return totalPages - pagesRead;
    }

    @Override
    public void finish() {
        super.finish();
        pagesRead = totalPages;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        try {
            return "title: " + getTitle() + " start: " + displayStartDate() + " genre: " + getGenre() + " end: " + displayEndDate() + " total pages: " + getTotalPages() + " pages read: " + getPagesRead() + " pages remaining: " + getPagesLeft() + " complete: " + isComplete() + "\n";
        } catch (NullPointerException e) {
            return "title: " + getTitle() + " start: " + displayStartDate() + " genre: " + getGenre() + " end: N/A" + " total pages: " + getTotalPages() + " pages read: " + getPagesRead() + " pages remaining: " + getPagesLeft() + " complete: " + isComplete() + "\n";
        }
    }
}